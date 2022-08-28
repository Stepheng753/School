package Lectures;

public class Lecture7 {

    public static void main(String[] args) {

        Test2 tst = new Test2();
        tst.print();
        System.out.println(tst.addSeven());
        tst.print();
        Lecture7 L7 = new Lecture7();
        System.out.println(L7.addSix(3));

    }
    public int addSix(int x)
    {
        x += 6;
        return x;
    }

}

class Test2 {

    static int x = 2;

    public void print() {
        x += 2;
        System.out.println("Hello " + x);
    }

    public int addSeven() {
        x += 7;
        return x;
    }

}
