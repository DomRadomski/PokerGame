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
}
