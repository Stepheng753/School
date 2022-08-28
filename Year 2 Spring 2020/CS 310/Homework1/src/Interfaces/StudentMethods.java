package Interfaces;

public interface StudentMethods {

    /**
     * Inserts Students, Option 1
     * @param name
     * @param age
     * @param ID
     */
    public void insertStudent(String name, int age, int ID);


    /**
     * Deletes Students, Option 2
     * @param id
     */
    public void deleteStudent(int id);


    /**
     * Displays All Students in Array, Option 3
     */
    public void displayAll();


    /**
     * Searches for Student based off ID, Option 4
     * @param id
     */
    public void searchStudent(String id);


    /**
     * Exits and Stops Program, Option 5
     */
    public void exit ();
}