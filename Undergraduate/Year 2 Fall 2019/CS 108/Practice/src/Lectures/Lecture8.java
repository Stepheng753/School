
package Lectures;


public class Lecture8
{
    public static void main(String [] args)
    {
        Integer x = 2;
        String y = x.toString(); // Object Class allows for .toString

        System.out.println(y.concat("+2=4"));

        while (x<=4) {
            try {
                if (x == 2) {
                    x++;
                        throw new NumberFormatException("Tester Bester");
                } else {
                    x++;
                    System.out.println("One More Time");
                }
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }

        Test1 tst = new Test1();
        try{
            tst.someMethod();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
    }
    }
}

class Test1 {
    public void someMethod() throws Exception {
        if (1 + 1 == 2) {
            throw new Exception("Some Method");
        }
    }
}

