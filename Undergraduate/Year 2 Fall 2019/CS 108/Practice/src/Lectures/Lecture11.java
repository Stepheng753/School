package Lectures;

public class Lecture11 extends AbstractClass implements Interface1, Interface2
{

    int x, y;
    @Override
    void setX(int x) {
        this.x = x;
    }

    @Override
    void setY(int y) {
        this.y = y;
    }

    @Override
    int getX() {
        return x;
    }

    @Override
    int getY() {
        return y;
    }

    @Override
    public void changeX(int x) {
        setX(x);
    }

    @Override
    public void changeY(int y) {
        setY(y);
    }

    public static void main(String[] args) {
        Lecture11 app = new Lecture11();
        app.setX(100);
        app.setY(102);
        app.Print(app);
        app.changeX(63);
        app.changeY(95);
        app.Print(app);
    }


}

abstract class AbstractClass {
    abstract void setX(int x);
    abstract void setY(int y);
    abstract int getX();
    abstract int getY();
    int getSum(int x, int y){
        return x + y;
    }
    void Print(Lecture11 app)
    {
        System.out.println("X :" + app.getX());
        System.out.println("Y :" + app.getY());
        System.out.println("X + Y :" + app.getSum(app.getX(),app.getY()));
    }
}

interface Interface1 {
     void changeX(int x);
}
interface Interface2 {
    void changeY(int y);
}



class Lecture11Voacb
{
    // Interface - similar to Abstract class
        // To make sure a class adheres to predefined rules
    // Interface - specify a set of Abstract methods that an implementing class must override and define
    // public interface Lecture11 ....
    // For method declaration, no need for the word abstract
    // for interface declaration, no class or abstract
    // public class Lecture10 implements Lecture11 ....

    // Abstract v Interface
    // Abstract classes can have implemented codes whereas Interfaces cannot
    // Only inherit ONE SUPERCLASS, implement many interfaces

    // Generics
    // A generic type is for when the user doesn't know the data type
    // A generic class is any class that uses a generic type
    // public class Generic <E>
        // Now Generic class is a Generic class and can use type <E>

    // <E> - element
    // <K> - key
    // <N> - number
    // <T> - type
    // <V> - value
    // S, U - 2nd and 3rd Generic types

}















