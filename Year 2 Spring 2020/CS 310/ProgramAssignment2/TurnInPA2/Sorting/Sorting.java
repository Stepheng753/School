package Sorting;

import java.util.LinkedList;

public interface Sorting <E> {
    public void insertionSort(LinkedList<E> list, int lowIndex, int highIndex, boolean reversed);
    public void quickSort(LinkedList<E> list, int lowIndex, int highIndex, boolean reversed);
    public void mergeSortLL(LinkedList<E> list, boolean reversed);
}