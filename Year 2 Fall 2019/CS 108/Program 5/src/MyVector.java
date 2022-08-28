/**
 * Program: 5
 * Description : My version of an ArrayList
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 11/25/2019
 **/

public class MyVector <E> extends MyAbstractList <E>
{

    int capacity = 10;           // capacity - How many Elements it can hold
    int incrementCapacity = 5;   // increment - How much to increase capacity
    public E[] myList;           // List of Data


    // One with no parameters that initializes the vector to a capacity of 10 elements
    @SuppressWarnings("unchecked")
    public MyVector(){
        capacity = 10;
        myList = (E[]) new Object[capacity];
        size = 0;
    }


    // One getting the initial capacity of the vector from the parameter
    @SuppressWarnings("unchecked")
    public MyVector(int capacity){
        this.capacity = capacity;
        myList = (E[]) new Object[this.capacity];
        size = 0;
    }


    // Another that take the initial capacity of the vector and the capacity increment
    @SuppressWarnings("unchecked")
    public MyVector(int capacity, int incrementCapacity){
        this.capacity = capacity;
        myList = (E[]) new Object[this.capacity];
        this.incrementCapacity = incrementCapacity;
    }


    /**
     * Appends the specified element to the end of this list,
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     * @param data
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean add(E data) {
        // Checks size of Array before Appending
        if (size == capacity) { newCapacity(); }

        myList[size] = data;    // index 'size' is the first empty index
        size++;                 // Added data means size goes up by 1

        // After Appending, if size = capacity, increase Capacity
        if (size == capacity) { newCapacity(); }

        return true;
    }


    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements by adding one to their indices.
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     * @param index - index at which the specified element is to be inserted
     * @param data - element to be inserted
     * @return boolean
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */
    @Override
    public boolean add(int index, E data) {
        // Size = Index is the same as adding to the end or 'add' method
        if (index == size){
            add(data);
            return true;
        }

        // If index is not within 0-size, throw IndexOutOfBoundsException
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        // Takes size of Array before Appending
        if (size == capacity) { newCapacity(); }

        // Goes backwards because forward wouldn't be correct
        // Makes the last nonempty index and sets it to the first empty index
        // And then indexes backwards.
        for (int i = size; i > index; i--) {
            myList[i] = myList[i - 1];
        }

        myList[index] = data;   // Adds data to index after everything has been shifted
        size++;                 // Added data means size goes up by 1

        // After Appending, if size = capacity, increase Capacity
        if (size == capacity) { newCapacity(); }
        return true;
    }


    /**
     * Removes all of the elements from this list
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        // Sets size to 0, because it will remove all elements
        size = 0;

        // Calls myList as a new Array clearing it all, but keeping same capacity
        myList = (E[]) new Object[capacity];
    }


    /**
     * Returns true if this list contains the specified element
     * @param data
     * @return boolean
     */
    @Override
    public boolean contains(E data) {
        // Goes through all elements, and searches if the parameter matches any elements
        for (int i = 0; i < size; i++) {
            if (myList[i].equals(data)){ return true; }
        }
        return false;
    }


    /**
     * Returns the element at the specified position in this list
     * @param index
     * @return E
     */
    @Override
    // Returns the Data at the specified Index
    public E get(int index) {
        return myList[index];
    }


    /**
     * Returns the index of the first occurrence of the specified element in this list
     * Return, or -1 if this list does not
     * contain the element
     * @param data
     * @return int
     */
    @Override
    public int indexOf(E data) {
        // Goes through all elements, and searches if the parameter matches any elements
        for (int i = 0; i < size; i++) {
            // Stops when found, and returns that specified index
            if (myList[i].equals(data)){ return i; }
        }
        return -1;
    }


    /**
     * Returns the index of the last matching of the element in this list
     * Return -1 if no match
     * @param data
     * @return int
     */
    @Override
    public int lastIndexOf(E data) {
        // Goes through all elements from last to first, and searches if the parameter matches any elements
        for (int i = size - 1; i >= 0; i--) {
            // Stops when found, and returns that specified index
            if (myList[i].equals(data)){ return i; }
        }
        return -1;
    }


    /**
     * Removes the  element at the specified position in this list.
     * Shifts any subsequent elements by subtracting one from their indices.
     * @param index - index of the element to be removed
     * @return E - the element that was removed from the list
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        // Grabs removedData before removing
        E removedData = myList[index];

        // Sets data from index + 1 to specified index, to remove it
        // Repeats for all indices.
        for (int i = index; i < size - 1; i++){
            myList[i] = myList[i + 1];
        }
        size--;     // Because of removal, size decreases

        return removedData;
    }


    /**
     * Trims the capacity of this MyVector instance to be the list's current size. An application
     * can use this operation to minimize the storage of a MyVector instance.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void trimToSize() {
        capacity = size;

        // Used to copy data
        E[] newList = (E[]) new Object[capacity];

        for (int i = 0; i < capacity; i++){
            // Copies all data from myList
            newList[i] = myList[i];
        }
        // Creates Array with the Same Capacity as size
        myList = newList;
    }


    /**
     * Increases Capacity while keeping earlier data
     */
    @SuppressWarnings("unchecked")
    public void newCapacity(){

        // Increases Capacity
        capacity += incrementCapacity;

        // Used to copy data
        E[] newList = (E[]) new Object[capacity];

        for (int i = 0; i < size; i++){
            // Copies all data from myList
            newList[i] = myList[i];
        }

        // Creates Empty Array with Bigger Capacity
        myList = newList;
    }


    /**
     * Returns the Capacity
     * @return int
     */
    public int getCapacity(){
        return capacity;
    }


    /**
     * Returns the Incrementer for capacity
     * @return int
     */
    public int getIncrement(){
        return incrementCapacity;
    }


    /**
     * Returns the Vector as a [ e1, e2...]
     * @return String
     */
    @Override
    public String toString(){
        // Starts with [
        String arrayStr = "[";

        // Adds in each element followed by a comma and a space
        for (int i = 0; i < size - 1; i++){
            arrayStr += myList[i] + ", ";
        }

        // Ensures Last one doesnt add space or comma
        arrayStr += myList[size -1] + "]";

        return arrayStr;
    }

}
