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

    private static final Map<String, Integer> HAND_RANKS = new HashMap<>();

    static {
        HAND_RANKS.put("High Card", 1);
        HAND_RANKS.put("Pair", 2);
        HAND_RANKS.put("Two Pair", 3);
        HAND_RANKS.put("Three of a Kind", 4);
        HAND_RANKS.put("Straight", 5);
        HAND_RANKS.put("Flush", 6);
        HAND_RANKS.put("Full House", 7);
        HAND_RANKS.put("Four of a Kind", 8);
        HAND_RANKS.put("Straight Flush", 9);
        HAND_RANKS.put("Royal Flush", 10);
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

    public AbstractMap.SimpleEntry<Boolean, String> isFourOfAKind() {

        if (getCards().get(0).getRank().equals(getCards().get(1).getRank())
                && getCards().get(1).getRank().equals(getCards().get(2).getRank())
                && getCards().get(2).getRank().equals(getCards().get(3).getRank())
        ) {
            return new AbstractMap.SimpleEntry<>(true, getCards().get(0).getRank());
        } else if (getCards().get(1).getRank().equals(getCards().get(2).getRank())
                && getCards().get(2).getRank().equals(getCards().get(3).getRank())
                && getCards().get(3).getRank().equals(getCards().get(4).getRank())
        ) {
            return new AbstractMap.SimpleEntry<>(true, getCards().get(1).getRank());
        } else
        {
            return new AbstractMap.SimpleEntry<>(false, "No four of a kind");
        }
    }


    public AbstractMap.SimpleEntry<Boolean, String> isFullHouse()
    {
        for (int i = 0; i < getCards().size()-2; i++)
        {
            // does current card equal the next card and the card after that
            if (getCards().get(i).getRank().equals(getCards().get(i+1).getRank()) &&
                    getCards().get(i).getRank().equals(getCards().get(i+2).getRank()))
            {
                // if a three of a kind is first 3 cards check the other cards are a pair
                if (i == 0 && getCards().get(3).getRank().equals(getCards().get(4).getRank()))
                {
                    return new AbstractMap.SimpleEntry<>(true, getCards().get(i).getRank());
                } else if (i == 2 && getCards().get(0).getRank().equals(getCards().get(1).getRank()))
                {
                    return new AbstractMap.SimpleEntry<>(true, getCards().get(i).getRank());
                }
            }
        }
        return new AbstractMap.SimpleEntry<>(false, "No full house");
    }

    public AbstractMap.SimpleEntry<Boolean, String> isFlush()
    {
        if (CardSuit(0).equals(CardSuit(1))
                && CardSuit(0).equals(CardSuit(2))
                && CardSuit(0).equals(CardSuit(3))
                && CardSuit(0).equals(CardSuit(3))
                && CardSuit(0).equals(CardSuit(4)))
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

    public AbstractMap.SimpleEntry<String, String> evaluateHand()
    {
        // Royal flush
        if (isFlush().getKey() && isStraight().getKey() && isStraight().getValue().equals("A"))
        {
            return new AbstractMap.SimpleEntry<>("Royal Flush", "A");
        }
        // Straight flush
        else if (isFlush().getKey() && isStraight().getKey())
        {
            return new AbstractMap.SimpleEntry<>("Straight Flush", isStraight().getValue());
        }
        // Four of a kind
        else if (isFourOfAKind().getKey())
        {
            return new AbstractMap.SimpleEntry<>("Four of a Kind", isFourOfAKind().getValue());
        }
        // Full house
        else if (isFullHouse().getKey())
        {
            return new AbstractMap.SimpleEntry<>("Full House", isFullHouse().getValue());
        }
        // Flush
        else if (isFlush().getKey())
        {
            return new AbstractMap.SimpleEntry<>("Flush", isFlush().getValue());
        }
        // Straight
        else if (isStraight().getKey())
        {
            return new AbstractMap.SimpleEntry<>("Straight", isStraight().getValue());
        }
        // Three of a kind
        else if (isThreeOfAKind().getKey())
        {
            return new AbstractMap.SimpleEntry<>("Three of a Kind", isThreeOfAKind().getValue());
        }
        // Two pair
        else if (isTwoPair().getKey())
        {
            return new AbstractMap.SimpleEntry<>("Two Pair", isTwoPair().getValue());
        }
        // Pair
        else if (isPair().getKey())
        {
            return new AbstractMap.SimpleEntry<>("Pair", isPair().getValue());
        }
        // High Card
        else
        {
            return new AbstractMap.SimpleEntry<>("High Card", isHighCard().getValue());
        }
    }

    // returns true if player hand is the winner
    public static int compare(PokerHand playerHand, PokerHand otherHand)
    {
        if (HAND_RANKS.get(playerHand.evaluateHand().getKey()) > HAND_RANKS.get(otherHand.evaluateHand().getKey()))
        {
            return 1;
        }

        else if (HAND_RANKS.get(playerHand.evaluateHand().getKey()) == HAND_RANKS.get(otherHand.evaluateHand().getKey()))
        {
            if (RANK_VALUES.get(playerHand.evaluateHand().getValue()) > RANK_VALUES.get(otherHand.evaluateHand().getValue()))
            {
                return 1;
            }
            else if (RANK_VALUES.get(playerHand.evaluateHand().getValue()) == RANK_VALUES.get(otherHand.evaluateHand().getValue()))
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }

        else
        {
            return -1;
        }
    }

    public static void main(String[] args)
    {
        PokerHand hand2 = new PokerHand(
                new Card("A", "Clubs"),
                new Card("A", "Clubs"),
                new Card("A", "Clubs"),
                new Card("K", "Clubs"),
                new Card("K", "hearts")
        );

        PokerHand hand1 = new PokerHand(
                new Card("A", "Clubs"),
                new Card("A", "Clubs"),
                new Card("A", "Clubs"),
                new Card("A", "Clubs"),
                new Card("J", "hearts")
        );

        System.out.println(hand2.compare(hand2, hand1));
    }

}
