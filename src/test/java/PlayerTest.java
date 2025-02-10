import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest
{
    @Test
    void testPlayerInitialization()
    {
        Player player = new Player("John", 1000);

        assertEquals("John", player.getName(), "Player name should be 'John'");
        assertEquals(1000, player.getChips(), "Player should start with 1000 chips");
        assertNull(player.getHand(), "Player should not have a hand at initialization");
    }

    @Test
    void testPlayerBetting()
    {
        Player player = new Player("John", 1000);

        player.bet(500);
        assertEquals(500, player.getChips(), "After betting 500, player should have 500 chips left");
    }

    @Test
    void testPlayerBettingMoreThanAvailable()
    {
        Player player = new Player("John", 1000);

        assertThrows(IllegalArgumentException.class, () -> player.bet(1100),
                "Insufficient chips! Cannot bet more than available.");
    }

    @Test
    void testPlayerWinsChips()
    {
        Player player = new Player("John", 1000);

        player.winChips(200);
        assertEquals(1200, player.getChips(), "Winning 200 chips should increase total to 1200");
    }

    @Test
    void testPlayerFolding()
    {
        Player player = new Player("John", 1000);

        player.setFoldStatus(true);
        assertTrue(player.isFolded(), "Player should be marked as folded after calling fold()");
    }

    @Test
    void testPlayerReceivesHand()
    {
        Player player = new Player("John", 1000);
        PokerHand hand = new PokerHand(
                new Card("2", "Hearts"),
                new Card("5", "Diamonds"),
                new Card("8", "Spades"),
                new Card("J", "Clubs"),
                new Card("A", "Hearts")
        );

        player.setHand(hand);
        assertEquals(hand, player.getHand(), "Player should correctly receive a poker hand");
    }






}
