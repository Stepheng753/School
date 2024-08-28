package Classes;

public class Student extends Person {

    private int ID;

    public Student (String name, int age, int ID) {
        super(name,age);
        setID(ID);
    }

    public void printInfo (Student a) {
        System.out.println("Student ID: " + getID());
        System.out.println("Student Name: " + getName());
        System.out.println("Student Age: " + getAge());
    }

    public void setID (int ID) {
        this.ID = ID;
    }

    public int getID () {
        return this.ID;
    }
}
