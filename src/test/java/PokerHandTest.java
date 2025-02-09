import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokerHandTest
{
    // Test a hand can be created
    @Test
    void testPokerHandCreationWithValidCards()
    {
        PokerHand hand = new PokerHand(
                new Card("2", "Hearts"),
                new Card("5", "Diamonds"),
                new Card("8", "Spades"),
                new Card("J", "Clubs"),
                new Card("A", "Hearts")
        );
        assertEquals(5, hand.getCards().size(), "Poker hand should contain exactly 5 cards");
    }

    // Test hand evaluation

    @Test
    void testEvaluateFlush()
    {
        PokerHand flushHand = new PokerHand(
                new Card("2", "Hearts"),
                new Card("5", "Hearts"),
                new Card("8", "Hearts"),
                new Card("J", "Hearts"),
                new Card("A", "Hearts")
        );
        assertEquals("Flush", flushHand.evaluateHand());
    }

    @Test
    void testEvaluateStraight()
    {
        PokerHand straightHand = new PokerHand(
                new Card("2", "Clubs"),
                new Card("3", "Diamonds"),
                new Card("4", "Spades"),
                new Card("5", "Hearts"),
                new Card("6", "Clubs")
        );
        assertEquals("Straight", straightHand.evaluateHand());
    }

    @Test
    void testEvaluatePair()
    {
        PokerHand pairHand = new PokerHand(
                new Card("2", "Clubs"),
                new Card("2", "Diamonds"),
                new Card("5", "Spades"),
                new Card("8", "Clubs"),
                new Card("K", "Hearts")
        );
        assertEquals("Pair", pairHand.evaluateHand());
    }

    @Test
    void testEvaluateHighCard()
    {
        PokerHand highCardHand = new PokerHand(
                new Card("2", "Clubs"),
                new Card("5", "Diamonds"),
                new Card("8", "Spades"),
                new Card("J", "Clubs"),
                new Card("A", "Hearts")
        );
        assertEquals("High Card", highCardHand.evaluateHand());
    }

    // Test hand comparison
    @Test
    void testFlushBeatsPair() {
        PokerHand flushHand = new PokerHand(
                new Card("2", "Hearts"),
                new Card("5", "Hearts"),
                new Card("8", "Hearts"),
                new Card("J", "Hearts"),
                new Card("A", "Hearts")
        );

        PokerHand pairHand = new PokerHand(
                new Card("2", "Clubs"),
                new Card("2", "Diamonds"),
                new Card("5", "Spades"),
                new Card("8", "Clubs"),
                new Card("K", "Hearts")
        );

        assertEquals(flushHand, PokerHand.compare(flushHand, pairHand));
    }

    @Test
    void testStraightBeatsThreeOfAKind()
    {
        PokerHand straightHand = new PokerHand(
                new Card("2", "Clubs"),
                new Card("3", "Diamonds"),
                new Card("4", "Spades"),
                new Card("5", "Hearts"),
                new Card("6", "Clubs")
        );

        PokerHand threeOfAKindHand = new PokerHand(
                new Card("7", "Clubs"),
                new Card("7", "Diamonds"),
                new Card("7", "Spades"),
                new Card("J", "Hearts"),
                new Card("A", "Clubs")
        );

        assertEquals(straightHand, PokerHand.compare(straightHand, threeOfAKindHand));
    }

    @Test
    void testCompareSameRankHighCardWins()
    {
        PokerHand hand1 = new PokerHand(
                new Card("3", "Clubs"),
                new Card("6", "Diamonds"),
                new Card("9", "Spades"),
                new Card("J", "Hearts"),
                new Card("A", "Clubs")
        );

        PokerHand hand2 = new PokerHand(
                new Card("2", "Clubs"),
                new Card("5", "Diamonds"),
                new Card("9", "Spades"),
                new Card("J", "Hearts"),
                new Card("K", "Clubs")
        );

        assertEquals(hand1, PokerHand.compare(hand1, hand2));
    }




}
