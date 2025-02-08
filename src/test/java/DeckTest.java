import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest
{
    @Test
    void testDeckInitialization() {
        Deck deck = new Deck();
        assertEquals(52, deck.size(), "Deck should contain 52 cards upon initialization");
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
    void testNoDuplicateCards()
    {
        Deck deck = new Deck();                // Step 1: Create a new deck
        Set<Card> dealtCards = new HashSet<>(); // Step 2: Use a Set to track dealt cards

        for (int i = 0; i < 52; i++) {          // Step 3: Deal all 52 cards
            Card dealtCard = deck.dealCard();   // Step 4: Get a card from the deck
            assertFalse(dealtCards.contains(dealtCard), "Duplicate card detected: " + dealtCard);
            dealtCards.add(dealtCard);          // Step 5: Add the card to the Set
        }

        assertEquals(52, dealtCards.size(), "All dealt cards should be unique");
    }


    @Test
    void testDeckShuffling()
    {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        assertNotEquals(deck1.getCards(), deck2.getCards(), "Two decks should have different card orders after shuffling");
    }





}
