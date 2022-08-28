package MainClass;

import Classes.Student;
import Interfaces.StudentMethods;
import java.util.Scanner;

public class MainClass implements StudentMethods {

    Student [] studentArray = new Student[10];
    int lastStudentIndex = 0;                       // This will tell me how many students in Array
    Scanner input = new Scanner(System.in);


    /**
     * Starts off My Printing Menu
     */
    public MainClass () {
        printMenu();
    }


    /**
     * Inserts Students, Option 1
     * @param name
     * @param age
     * @param ID
     */
    @Override
    public void insertStudent(String name, int age, int ID) {
        studentArray[lastStudentIndex] = new Student(name, age, ID);;
        lastStudentIndex++;
        System.out.println("Student Inserted!");
        printMenu();
    }


    /**
     * Deletes Students, Option 2
     * @param id
     */
    @Override
    public void deleteStudent(int id) {
        // Iterates Through all Students in Array
        for (int i = 0; i < lastStudentIndex; i++) {
            // If ID's match, then delete and shift
            if (studentArray[i].getID() == id) {
                studentArray[i].printInfo(studentArray[i]);
                for (int j = i; j < lastStudentIndex - 1; j++) {
                    studentArray[j] = studentArray[j + 1];
                }
                // Decrement because 1 less student
                lastStudentIndex--;
                System.out.println("Student Deleted!");
                break;
            } else if (i == lastStudentIndex - 1) {
                System.out.println("Student NOT FOUND!");
            }
        }
        printMenu();
    }


    /**
     * Searches for Student based off ID, Option 3
     * @param id
     */
    @Override
    public void searchStudent(String id) {
        int idSearch = Integer.valueOf(id);
        // Iterates Through all Students in Array
        for (int i = 0; i < lastStudentIndex; i++) {
            // If ID's match, then printInfo
            if (studentArray[i].getID() == idSearch) {
                studentArray[i].printInfo(studentArray[i]);
                break;
            } else if (i == lastStudentIndex - 1) {
                System.out.println("Student NOT FOUND!");
            }
        }
        printMenu();
    }


    /**
     * Displays All Students in Array, Option 4
     */
    @Override
    public void displayAll() {
        for (int i = 0; i < lastStudentIndex; i++) {
            studentArray[i].printInfo(studentArray[i]);
            System.out.println();
        }
        printMenu();
    }


    /**
     * Exits and Stops Program, Option 5
     */
    @Override
    public void exit () {
        System.out.println("Thank You!");
        System.exit(0);
    }


    /**
     * Prints Menu
     */
    public void printMenu() {
        System.out.println();
        System.out.println("User Menu:");
        System.out.println("Input Choice:");
        System.out.println("1. Insert Student");
        System.out.println("2. Delete Student by ID");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
        System.out.print("Insert Number: ");
        choices();
    }


    /**
     * Takes in Input, and does option
     */
    public void choices () {
        if (input.hasNextInt()) {
            int choices = input.nextInt();
            System.out.println();
            if (choices == 1) {
                // Checks to see if Array is not full
                if (lastStudentIndex < 10) {
                    System.out.print("Input Student ID: ");
                    int ID = input.nextInt();

                    // Checks to see if ID matches other ID's
                    boolean sameID = false;
                    for (int i = 0; i < lastStudentIndex; i++) {
                        if (studentArray[i].getID() == ID) {
                            sameID = true;
                        }
                    }

                    if (sameID == false) {
                        System.out.print("Input Student Name: ");
                        String name = input.next();
                        System.out.print("Input Student Age: ");
                        int age = input.nextInt();
                        insertStudent(name, age, ID);
                    } else {
                        System.out.println("ID has already been inserted!");
                        printMenu();
                    }
                } else {
                    System.out.println("Maximum Students Held!");
                    printMenu();
                }
            }
            if (choices == 2) {
                // Checks for empty array
                if (lastStudentIndex == 0) {
                    System.out.println("No Students in Array!");
                    printMenu();
                } else {
                    System.out.print("Input Student ID to delete: ");
                    int ID = input.nextInt();
                    deleteStudent(ID);
                }
            }
            if (choices == 3) {
                // Checks for empty array
                if (lastStudentIndex == 0) {
                    System.out.println("No Students in Array!");
                    printMenu();
                } else {
                    System.out.print("Input Student ID to search: ");
                    String ID = input.next();
                    searchStudent(ID);
                }
            }
            if (choices == 4) {
                // Checks for empty array
                if (lastStudentIndex == 0) {
                    System.out.println("No Students in Array!");
                    printMenu();
                } else {
                    displayAll();
                }
            }
            if (choices == 5) {
                exit();
            }
            if ((choices != 1) && (choices != 2) && (choices != 3) && (choices != 4) && (choices != 5)) {
                System.out.println("Invalid Number");
                printMenu();
            }
        }
        else {
            System.out.println("\nInvalid Input");
            input = new Scanner(System.in);
            printMenu();
        }
    }


    public static void main(String[] args) {
        new MainClass();
    }


}




