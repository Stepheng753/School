package Lectures;

import java.util.ArrayList;
import java.util.List;

public class Lecture5
{
    public static void main(String [] args)
    {
        // ArraysLists + Wrappers
        {
            List<Integer> aList = new ArrayList<>();
            int y = 2;
            Integer x = y + 5; // Unboxing //Wrapper: Integer
            aList.add(y); //Autoboxing
            aList.add(56);
            aList.remove(1);
            aList.add(x);
            System.out.println(aList.get(1));
        }

    }

}
