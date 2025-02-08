import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest
{
    @Test
    void testDeckInitialization() {
        Deck deck = new Deck();
        assertEquals(52, deck.cards.size(), "Deck should contain 52 cards upon initialization");
    }

    @Test
    void testDealingCardReducesDeckSize()
    {
        Deck deck = new Deck();
        int initialSize = deck.size();
        deck.dealCard();
        assertEquals(initialSize - 1, deck.size(), "Dealing a card should reduce the deck size by 1");
    }

    @Test
    void testDealingAllCards()
    {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            deck.dealCard();
        }
        assertEquals(0, deck.size(), "Deck should be empty after dealing all 52 cards");
    }

    @Test
    void testDeckShuffling()
    {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        assertNotEquals(deck1.getCards(), deck2.getCards(), "Two decks should have different card orders after shuffling");
    }





}
