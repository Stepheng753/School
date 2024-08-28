/**
 * Program 2b
 * Description :
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 9/16/2019
 **/

import java.util.Random;
public class CardDeck
{
    public String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public String[] deck = new String[52];
    // initialize to size of 52 for the number of cards there are in a standard deck (NO JOKERS)

    //Returns Program # + Name
    public String getIdentificationString()
    {
        return "Program 2b, Stephen Giang";
    }

    // Inserts a deck
    public CardDeck()
    {
        int num = 0; //initializes num to be imported for deck[num]

        for (int i = 0; i < 13; i++) //Loops through each rank
        {
            for (int j = 0; j < 4; j++) //Loops through each suit
            {
                deck [num] = ranks[i] + " of " + suits[j];
                num += 1;
            }
        }
    }

    //Returns the Card at specific index
    public String getCard(int index)
    {
        return deck[index];
    }

    //Returns the first card in the deck
    public String getFirst()
    {
        return getCard(0);
    }

    //Returns the last card in the deck
    public String getLast()
    {
        return getCard(51);
    }

    //Returns a Random Card
    public String randomCard()
    {
        Random rand = new Random();
        return deck[rand.nextInt(51)];
    }

    // Returns Royal Flushes with a comma and space
    public String royalFlush()
    {
        return getCard(34) + ", " + getCard(38) + ", " +
                getCard(42) + ", " + getCard(46) + ", " + getCard(50);
    }

}
