import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck
{
    protected List<Card> cards = new ArrayList<>();
    private String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"} ;
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Deck()
    {
        List<Card> initDeck = new ArrayList<>();
        for (String suit : suits)
        {
            for (String rank : ranks)
            {
                Card card = new Card(rank, suit);
                initDeck.add(card);
            }
        }

        // Shuffle the new deck

        Random random = new Random();
        for (int i = 52; i > 0; i--)
        {
            int randomIndex = random.nextInt(i);
            this.cards.addLast(initDeck.get(randomIndex));
            initDeck.remove(randomIndex);
        }



    }

    public Card dealCard()
    {
        Card card = this.cards.getFirst();
        this.cards.removeFirst();
        return card;
    }

    public int size()
    {
        return this.cards.size();
    }

    public List<Card> getCards()
    {
        return this.cards;
    }





    public static void main(String[] args)
    {
        Deck deck = new Deck();
        for (Card card : deck.cards)
        {
            System.out.println(card.toString());
        }
        System.out.println(deck.size());
    }
}
