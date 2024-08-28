

import java.util.Random;
import java.util.Arrays;
public class FiveCards
{

    public static String getInfo()
    {
        return "Program 1, Stephen Giang";
    }

    public static int[] initHand(int deckSize, int handSize, long randomGeneratorSeed)
    {
        Random rand = new Random(randomGeneratorSeed);
        int hand [] = new int  [handSize];

        for (int i = 0; i < hand.length; i++)
        {
            hand[i] = rand.nextInt(deckSize);
        }
        for (int i = 0; i < 3; i++)
        {
            if (hand[i] == hand[i+1])
            {
                hand[i+1] = hand[i+1+1];
                hand[4] = rand.nextInt(deckSize);
            }
        }

        return hand;
    }

    public static String getSuit(int cardNumber)
    {
        String suit = "suit";

        if (cardNumber >= 0 && cardNumber <= 12)
            suit = "Clubs";
        if (cardNumber >= 13 && cardNumber <= 25)
            suit = "Diamonds";
        if (cardNumber >= 26 && cardNumber <= 38)
            suit = "Hearts";
        if (cardNumber >= 39 && cardNumber <= 51)
            suit = "Spades";

        return suit;
    }

    public static String getRank(int cardNumber)
    {
        String rank = "rank";
        for (int n = 0; n < 4; n++)
        {
            if (cardNumber == (0+13*n))
                rank = "Ace";
            if (cardNumber == (1+13*n))
                rank = "Two";
            if (cardNumber == (2+13*n))
                rank = "Three";
            if (cardNumber == (3+13*n))
                rank = "Four";
            if (cardNumber == (4+13*n))
                rank = "Five";
            if (cardNumber == (5+13*n))
                rank = "Six";
            if (cardNumber == (6+13*n))
                rank = "Seven";
            if (cardNumber == (7+13*n))
                rank = "Eight";
            if (cardNumber == (8+13*n))
                rank = "Nine";
            if (cardNumber == (9+13*n))
                rank = "Ten";
            if (cardNumber == (10+13*n))
                rank = "Jack";
            if (cardNumber == (11+13*n))
                rank = "Queen";
            if (cardNumber == (12+13*n))
                rank = "King";
        }
        return rank;
    }

    public static String getCardValue(int cardNumber)
    {
        return (getRank(cardNumber) + " of " + getSuit(cardNumber));
    }

    public static void showHand(int [] hand)
    {
        for (int i = 0; i < hand.length; i++)
        {
            System.out.println(getCardValue(hand[i]));
        }
        System.out.print("\n");
    }

    public static void sameSuit(int [] hand)
    {
        Arrays.sort(hand, 0, hand.length);

        for (int i = 0; i < hand.length ; i++)
        {
            for (int j = 0 ; j < hand.length; j++)
            {
                if ((i != j) && (getSuit(hand[i]) == getSuit(hand[j])))
                {
                    System.out.println(getCardValue(hand[i]));
                    break;
                }
            }
        }
    }


    public static void main (String[] args)
    {
        int hand [] = initHand(52,5,1111);
        showHand(hand);
        sameSuit(hand);
    }
}
