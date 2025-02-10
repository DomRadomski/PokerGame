public class Player
{
    private String name;
    private int chips;
    private PokerHand hand;
    private boolean isFolded;

    public Player(String inputName, int startingChips)
    {
        this.name = inputName;
        this.chips = startingChips;
        this.isFolded = false;
    }

    public String getName()
    {
        return this.name;
    }

    public int getChips()
    {
        return this.chips;
    }

    public PokerHand getHand()
    {
        return this.hand;
    }

    public void setHand(PokerHand hand)
    {
        this.hand = hand;
    }

    public void bet(int amount) {
        if (amount > this.chips) {
            throw new IllegalArgumentException("Insufficient chips! Cannot bet more than available.");
        }
        this.chips -= amount;
    }



    public void winChips(int amount)
    {
        this.chips += amount;
    }

    public void setFoldStatus(boolean b)
    {
        this.isFolded = b;
    }

    public boolean isFolded()
    {
        return this.isFolded;
    }
}
