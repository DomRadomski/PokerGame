import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void cardStoresRankAndSuit()
    {
        Card card = new Card("Ace", "Hearts");
        assertEquals("Ace", card.getRank());
        assertEquals("Hearts", card.getSuit());
    }

    @Test
    void cardToStringReturnsCorrectFormat()
    {
        Card card = new Card("King", "Spades");
        assertEquals("King of Spades", card.toString());
    }
}

