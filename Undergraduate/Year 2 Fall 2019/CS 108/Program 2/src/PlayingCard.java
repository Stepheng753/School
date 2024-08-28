/**
 * Program 2a
 * Description : Make Methods that return Info about Cards
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 9/16/2019
 **/


public class PlayingCard
{
    public String rank;
    public String suit;

    //Returns Program # + Name
    public String getIdentificationString()
    {
        return "Program 2a, Stephen Giang";
    }

    //Assigns the rank and suit with the parameters
    public PlayingCard(String rank, String suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    //Tells whether Good Card or 'Alright' Card
    public String goodCard(String rank)
    {
        if (rank == "10" || rank == "Jack" || rank == "Queen" || rank == "King" || rank == "Ace" )
        {
            return ("That's a good card!");
        }
        else
        {
            return ("This card is alright.");
        }
    }

    //Returns Rank
    public String getRank()
    {
        return this.rank;
    }

    //Returns Suit
    public String getSuit()
    {
        return this.suit;
    }

    //Returns the Card, Rank and Suit
    public String toString()
    {
        return (getRank() + " of " + getSuit());
    }
}
