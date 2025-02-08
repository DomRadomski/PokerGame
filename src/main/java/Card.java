import java.util.Objects;

public class Card
{
    private final String rank;
    private final String suit;

    public Card(String inputRank, String inputSuit)
    {
        this.rank = inputRank;
        this.suit = inputSuit;
    }

    public String getRank()
    {
        return this.rank;
    }

    public String getSuit()
    {
        return this.suit;
    }

    public String toString()
    {
        return getRank() + " of " + getSuit();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;  // Step 1: Same memory reference → they are equal
        if (obj == null || getClass() != obj.getClass()) return false; // Step 2: Null or different class → not equal

        Card card = (Card) obj;  // Step 3: Cast to Card
        return this.rank.equals(card.rank) && this.suit.equals(card.suit); // Step 4: Compare rank and suit
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }


}
