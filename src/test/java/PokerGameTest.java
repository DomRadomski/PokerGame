import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokerGameTest
{
    /*@Test
    void testPokerGameInitialization()
    {
        PokerGame game = new PokerGame(3, 1000); // 3 players, each with 1000 chips

        assertEquals(3, game.getPlayers().size(), "Game should initialize with 3 players");
        assertNotNull(game.getDeck(), "Game should initialize with a deck");
    }

    @Test
    void testDealingFiveCardsToPlayers()
    {
        PokerGame game = new PokerGame(3, 1000);
        game.dealPlayerCards(); // Deal 5 cards to each player

        for (Player player : game.getPlayers()) {
            assertEquals(5, player.getHand().getCards().size(), "Each player should have 5 cards after dealing");
        }
    }

    @Test
    void testPlayerBettingInGame()
    {
        PokerGame game = new PokerGame(3, 1000);
        Player player = game.getPlayers().get(0);

        int betAmount = game.placeBet(player, 200);
        assertEquals(800, player.getChips(), "Player should have 800 chips after betting 200");
        assertEquals(200, betAmount, "The game should correctly track the bet amount");
    }

    @Test
    void testPlayerFoldingInGame()
    {
        PokerGame game = new PokerGame(3, 1000);
        Player player = game.getPlayers().get(0);

        player.setFoldStatus(true);
        assertTrue(player.isFolded(), "Player should be marked as folded");
    }

    @Test
    void testDetermineWinner() {
        PokerGame game = new PokerGame(3, 1000);

        // Manually assign hands to control the winner
        game.getPlayers().get(0).setHand(new PokerHand(
                new Card("A", "Hearts"), new Card("A", "Diamonds"),
                new Card("K", "Spades"), new Card("Q", "Clubs"),
                new Card("J", "Hearts"))); // Strong hand

        game.getPlayers().get(1).setHand(new PokerHand(
                new Card("2", "Clubs"), new Card("3", "Spades"),
                new Card("4", "Diamonds"), new Card("5", "Clubs"),
                new Card("6", "Hearts"))); // Weak hand

        game.getPlayers().get(2).setHand(new PokerHand(
                new Card("K", "Spades"), new Card("Q", "Hearts"),
                new Card("J", "Diamonds"), new Card("10", "Spades"),
                new Card("9", "Clubs"))); // Straight

        Player winner = game.determineWinner();
        assertEquals(game.getPlayers().get(0), winner, "Player with strongest hand should be the winner");
    }

    @Test
    void testPlayerCanExchangeCards()
    {
        PokerGame game = new PokerGame(3, 1000);
        Player player = game.getPlayers().get(0);

        int[] cardsToReplace = {0,1,3};
        game.exchangeCards(player, cardsToReplace);

        assertEquals(5, player.getHand().getCards().size(), "Player should still have 5 cards after exchanging");
    }

    @Test
    void testPlayerCannotExchangeMoreThanThreeCards()
    {
        PokerGame game = new PokerGame(3, 1000);
        Player player = game.getPlayers().get(0);

        int[] cardsToReplace = {0,1,2,3,4}; // Trying to exchange all 5
        assertThrows(IllegalArgumentException.class, () -> game.exchangeCards(player, cardsToReplace),
                "Should not allow exchanging more than 3 cards");
    }*/
}


