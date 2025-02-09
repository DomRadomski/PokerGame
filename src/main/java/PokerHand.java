import java.util.*;

public class PokerHand
{

    private List<Card> cards;
    private static final Map<String, Integer> RANK_VALUES = new HashMap<>();

    static {
        RANK_VALUES.put("2", 2);
        RANK_VALUES.put("3", 3);
        RANK_VALUES.put("4", 4);
        RANK_VALUES.put("5", 5);
        RANK_VALUES.put("6", 6);
        RANK_VALUES.put("7", 7);
        RANK_VALUES.put("8", 8);
        RANK_VALUES.put("9", 9);
        RANK_VALUES.put("10", 10);
        RANK_VALUES.put("J", 11);
        RANK_VALUES.put("Q", 12);
        RANK_VALUES.put("K", 13);
        RANK_VALUES.put("A", 14);
    }

    public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5)
    {
        Card[] unsortedCards = {card1, card2, card3, card4, card5};
        this.cards = Arrays.asList(unsortedCards);
        this.cards.sort(Comparator.comparingInt(card -> RANK_VALUES.get(card.getRank())));
    }

    public List<Card> getCards()
    {
        return this.cards;
    }

    public int CardRank(int index)
    {
        return RANK_VALUES.get(getCards().get(index).getRank());
    }

    public String CardSuit(int index)
    {
        return getCards().get(index).getSuit();
    }

    public boolean isFullHouse()
    {
        return false;
    }

    public AbstractMap.SimpleEntry<Boolean, String> isFlush()
    {
        if (CardSuit(0).equals(CardSuit(1))
                && CardSuit(0).equals(CardSuit(2))
                && CardSuit(0).equals(CardSuit(3))
                && CardSuit(0).equals(CardSuit(3)))
        {
            return new AbstractMap.SimpleEntry<>(true, getCards().get(4).getRank());
        }

        return new AbstractMap.SimpleEntry<>(false, "No flush");
    }

    //RANK_VALUES.get(card.getRank())
    public AbstractMap.SimpleEntry<Boolean, String> isStraight()
    {
        if (CardRank(0) == CardRank(1)-1
                && CardRank(1) == CardRank(2)-1
                && CardRank(2) == CardRank(3)-1
                && CardRank(3) == CardRank(4)-1)
        {
            return new AbstractMap.SimpleEntry<>(true, getCards().get(4).getRank());
        }

        return new AbstractMap.SimpleEntry<>(false, "No straight");
    }

    public AbstractMap.SimpleEntry<Boolean, String> isThreeOfAKind()
    {
        for (int i = 0; i < getCards().size()-2; i++)
        {
            // does current card equal the next card and the card after that
            if (getCards().get(i).getRank().equals(getCards().get(i+1).getRank()) &&
                    getCards().get(i).getRank().equals(getCards().get(i+2).getRank()))
            {
                return new AbstractMap.SimpleEntry<>(true, getCards().get(i).getRank());
            }
        }

        return new AbstractMap.SimpleEntry<>(false, "No three of a kind");
    }

    public AbstractMap.SimpleEntry<Boolean, String> isTwoPair()
    {
        int pairCount = 0;

        for (int i = 0; i < getCards().size()-1; i++)
        {
            // does current card equal the next card
            // will return true if we have three of a kind but
            // we will test for toak before two pair in evaluation
            if (getCards().get(i).getRank().equals(getCards().get(i+1).getRank()))
            {
                pairCount++;
                if (pairCount == 2)
                {
                    // Will return rank of current pair which will be the highest
                    return new AbstractMap.SimpleEntry<>(true, getCards().get(i).getRank());
                }
            }
        }

        return new AbstractMap.SimpleEntry<>(false, "No two pair");

    }

    public AbstractMap.SimpleEntry<Boolean, String> isPair()
    {
        for (int i = 0; i < getCards().size()-1; i++)
        {
            // does current card equal the next card
            if (getCards().get(i).getRank().equals(getCards().get(i+1).getRank()))
            {
                return new AbstractMap.SimpleEntry<>(true, getCards().get(i).getRank());
            }
        }

        return new AbstractMap.SimpleEntry<>(false, "No pair");
    }

    public AbstractMap.SimpleEntry<Boolean, String> isHighCard()
    {
        return new AbstractMap.SimpleEntry<>(true, getCards().get(4).getRank());
    }

    public String evaluateHand()
    {
        return this.getCards().toString();
    }

    public boolean compare(PokerHand hand, PokerHand otherHand)
    {
        return true;
    }

    public static void main(String[] args)
    {
        PokerHand hand2 = new PokerHand(
                new Card("A", "Clubs"),
                new Card("K", "Clubs"),
                new Card("Q", "Clubs"),
                new Card("J", "Clubs"),
                new Card("10", "Clubs")
        );

        System.out.println(hand2.isFlush());
    }

}
