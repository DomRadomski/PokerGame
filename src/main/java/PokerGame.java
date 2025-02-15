import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokerGame
{
    private Deck deck;
    private List<Player> players = new ArrayList<>();
    private int currentBet;
    private int pot;

    public PokerGame(int numPlayers, int startingChips)
    {
        // Initialise Deck
        this.deck = new Deck();
        // Initialise Players
        for (int i = 0; i < numPlayers; i++)
        {
            Player player = new Player("Player " + i, startingChips);
            this.players.addLast(player);
        }
        this.currentBet = 0;
        this.pot = 0;
    }

    public List<Player> getPlayers() {
        return this.players;
    }


    public Deck getDeck() {
        return this.deck;
    }

    public void dealPlayerCards()
    {
        for (Player player : this.players)
        {
            Card[] cards = new Card[5];

            for (int i = 0; i < 5; i++)
            {
                cards[i] = getDeck().dealCard();
            }

            PokerHand hand = new PokerHand(cards);
            player.setHand(hand);
        }
    }

    public void exchangeCards(Player player, int[] cardsToReplace)
    {
        for (int i : cardsToReplace)
        {
            player.getHand().changeCard(getDeck(),i);
        }
    }

    public void placeBet(Player player, int amount)
    {
        player.bet(amount);
    }

    public void foldPlayer(Player player)
    {
        player.setFoldStatus(true);
    }

    public Player determineWinner()
    {
        Player winner = getPlayers().getFirst();

        for (Player player : getPlayers())
        {
            if (winner.getHand().compareHands(player.getHand()) == -1)
            {
                winner = player;
            }
        }

        return winner;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many people are playing: ");
        int numPlayers = scanner.nextInt();

        PokerGame game = new PokerGame(numPlayers, 1000);

        game.dealPlayerCards();
        // exchange cards
        for (Player player : game.getPlayers())
        {
            System.out.println(player.getHand().getCards().toString());
            // init current card index
            int currentCardIndex = 0;
            // init exchanged card counter
            int cardsExchanged = 0;
            // input how many cards to exchange
            System.out.print("How many cards would you like to exchange: ");
            int numToExchange = scanner.nextInt();
            // init indexs to exchange
            int[] cardsToExchange = new int[numToExchange];

            while (cardsExchanged < numToExchange)
            {
                System.out.print(
                      "Would you like to exchange " +
                      player.getHand().getCards().get(currentCardIndex) +
                      " (y/n)?"
                );
                // respond to question
                String exchange = scanner.next();

                if (exchange.equals("y"))
                {
                    cardsToExchange[cardsExchanged] = currentCardIndex;
                    cardsExchanged++;
                }
                currentCardIndex++;
            }

            game.exchangeCards(player, cardsToExchange);
            player.getHand().sortHand();
        }

        for (Player player : game.getPlayers())
        {
            System.out.println(player.getHand().getCards().toString());
        }

        System.out.println(
                game.determineWinner().getName() +
                        " is the winner"
        );
    }

}
