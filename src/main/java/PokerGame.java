import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < players.size(); i++)
        {
            Player player = new Player("Player " + i, startingChips);
            this.players.addLast(player);
        }
        this.currentBet = 0;
        this.pot = 0;
    }

    public void dealPlayerCards()
    {
        for (Player player : players)
        {
            for (int i = 1; i <= 5; i++)
            {
                Card card = this.deck.dealCard();
            }
        }
    }


}
