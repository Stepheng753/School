package Sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Random;

public class SortingTestPrint<E> implements Sorting<E> {

    int inc = 1;

    public SortingTestPrint () {

    }

    public static void main(String[] args) throws FileNotFoundException {
        SortingTestPrint <Integer> sorting = new SortingTestPrint <Integer>();
        int [] outputArray = {10, 50, 100, 150, 300, 500, 1000, 1500};

        sorting.insertionTest(sorting, outputArray);
        sorting.quickTest(sorting, outputArray);
        sorting.mergeTest(sorting, outputArray);
    }

    private void insertionTest (SortingTestPrint <Integer> sorting, int [] outputArray) throws FileNotFoundException {
        PrintWriter pWriter = new PrintWriter(new FileOutputStream("C:\\Users\\Stephen Giang\\Google Drive\\School\\Year 2 Spring 2020\\CS 310\\ProgramAssignment2\\PrintTests\\InsertionTest.txt"));
        Random randomNum = new Random();
        pWriter.println("------------------\n");
        LinkedList<Integer> list;

        for (int j = 0; j < outputArray.length; j++) {
            list = new LinkedList<>();
            for (int i = 0; i < outputArray[j]; i++) {
                list.add(randomNum.nextInt(outputArray[j]));
            }
            pWriter.println("Original List for: " + outputArray[j] + " outputs\n");
            printList(list,pWriter);

            double start = System.nanoTime();
            sorting.insertionSort(list, 1, list.size() - 1, false);
            double end = System.nanoTime();
            pWriter.println("\nInsertion Unsorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");
            printList(list,pWriter);

            start = System.nanoTime();
            sorting.insertionSort(list, 1, list.size() - 1, false);
            end = System.nanoTime();
            pWriter.println("\nInsertion Sorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");
            printList(list,pWriter);

            start = System.nanoTime();
            sorting.insertionSort(list, 1, list.size() - 1, true);
            end = System.nanoTime();
            pWriter.println("\nInsertion Reversed Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");
            printList(list,pWriter);
            pWriter.println("\n------------------\n");
        }

        pWriter.close();
    }

    private void quickTest (SortingTestPrint <Integer> sorting, int [] outputArray) throws FileNotFoundException {
        PrintWriter pWriter = new PrintWriter(new FileOutputStream("C:\\Users\\Stephen Giang\\Google Drive\\School\\Year 2 Spring 2020\\CS 310\\ProgramAssignment2\\PrintTests\\QuickTest.txt"));
        Random randomNum = new Random();
        pWriter.println("------------------\n");
        LinkedList<Integer> list;

        for (int j = 0; j < outputArray.length; j++) {
            list = new LinkedList<>();
            for (int i = 0; i < outputArray[j]; i++) {
                list.add(randomNum.nextInt(outputArray[j]));
            }
            pWriter.println("Original List for: " + outputArray[j] + " outputs\n");
            printList(list,pWriter);

            double start = System.nanoTime();
            sorting.quickSort(list, 0, list.size() - 1, false);
            double end = System.nanoTime();
            pWriter.println("\nQuick Unsorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");
            printList(list,pWriter);

            start = System.nanoTime();
            sorting.quickSort(list, 0, list.size() - 1, false);
            end = System.nanoTime();
            pWriter.println("\nQuick Sorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");
            printList(list,pWriter);

            start = System.nanoTime();
            sorting.quickSort(list, 0, list.size() - 1, true);
            end = System.nanoTime();
            pWriter.println("\nQuick Reversed Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");
            printList(list,pWriter);
            pWriter.println("\n------------------\n");
        }

        pWriter.close();
    }

    private void mergeTest (SortingTestPrint <Integer> sorting, int [] outputArray) throws FileNotFoundException {
        PrintWriter pWriter = new PrintWriter(new FileOutputStream("C:\\Users\\Stephen Giang\\Google Drive\\School\\Year 2 Spring 2020\\CS 310\\ProgramAssignment2\\PrintTests\\MergeTest.txt"));
        Random randomNum = new Random();
        pWriter.println("------------------\n");
        LinkedList<Integer> list;

        for (int j = 0; j < outputArray.length; j++) {
            list = new LinkedList<>();
            for (int i = 0; i < outputArray[j]; i++) {
                list.add(randomNum.nextInt(outputArray[j]));
            }
            pWriter.println("Original List for: " + outputArray[j] + " outputs\n");
            printList(list,pWriter);

            double start = System.nanoTime();
            sorting.mergeSortLL(list, false);
            double end = System.nanoTime();
            pWriter.println("\nMerge Unsorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");
            printList(list,pWriter);

            start = System.nanoTime();
            sorting.mergeSortLL(list, false);
            end = System.nanoTime();
            pWriter.println("\nMerge Sorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");
            printList(list,pWriter);

            start = System.nanoTime();
            sorting.mergeSortLL(list, true);
            end = System.nanoTime();
            pWriter.println("\nMerge Reversed Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");
            printList(list,pWriter);
            pWriter.println("\n------------------\n");
        }

        pWriter.close();
    }


    @Override
    public void insertionSort(LinkedList<E> list, int lowIndex, int highIndex, boolean reversed) {
        E key = list.get(lowIndex);
        int prevIndex = lowIndex - 1;

        if (reversed == false) {
            while (prevIndex >= 0 && compareTo(list.get(prevIndex),key) > 0) {
                list.set(prevIndex + 1, list.get(prevIndex));
                prevIndex--;
            }
        } else {
            while (prevIndex >= 0 && compareTo(list.get(prevIndex),key) < 0) {
                list.set(prevIndex + 1, list.get(prevIndex));
                prevIndex--;
            }
        }
        list.set(prevIndex + 1,key);

        if (lowIndex < highIndex) {
            insertionSort(list, lowIndex + 1, highIndex, reversed);
        }
    }

    @Override
    public void quickSort(LinkedList<E> list, int lowIndex, int highIndex, boolean reversed) {
        E pivot;

        if (highIndex > lowIndex) {
            int midpointIndex = (highIndex + lowIndex) / 2;

            swap(list, midpointIndex, highIndex);
            pivot = list.get(highIndex);

            int incrementer = lowIndex;
            int lastKeyIndex = lowIndex;
            if (reversed == false) {
                while (incrementer <= highIndex) {
                    if (compareTo(list.get(incrementer),pivot) > 0) {
                        incrementer++;
                    } else {
                        swap(list, incrementer, lastKeyIndex);
                        incrementer++;
                        lastKeyIndex++;
                    }
                }
                quickSort(list, lowIndex, lastKeyIndex - 2, false);
                quickSort(list, lastKeyIndex, highIndex, false);
            }
            else {
                while (incrementer <= highIndex) {
                    if (compareTo(list.get(incrementer),pivot) < 0) {
                        incrementer++;
                    } else {
                        swap(list, incrementer, lastKeyIndex);
                        incrementer++;
                        lastKeyIndex++;
                    }
                }
                quickSort(list, lowIndex, lastKeyIndex - 2, true);
                quickSort(list, lastKeyIndex, highIndex, true);
            }
        }

    }

    private void swap (LinkedList<E> list, int index1, int index2) {
        E index1Element = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, index1Element);
    }

    @Override
    public void mergeSortLL(LinkedList<E> list, boolean reversed) {
        int listSize = list.size();

        if (listSize > 1) {
            int halfSize = listSize / 2;

            LinkedList<E> leftList = new LinkedList<>();
            LinkedList<E> rightList = new LinkedList<>();
            for (int i = 0; i < halfSize; i++) {
                leftList.add(list.get(i));
            }
            for (int i = halfSize; i < listSize; i++) {
                rightList.add(list.get(i));
            }

            mergeSortLL(leftList, reversed);
            mergeSortLL(rightList, reversed);

            mergeTwoLists(leftList,rightList,list, reversed);
        }

    }

    private void mergeTwoLists(LinkedList<E> leftList, LinkedList<E> rightList, LinkedList<E> mergedList, boolean reversed) {
        int leftSize = leftList.size();
        int rightSize = rightList.size();
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            E leftElement = leftList.get(leftIndex);
            E rightElement = rightList.get(rightIndex);

            if (reversed == false) {
                if (compareTo(leftElement, rightElement)< 0) {
                    mergedList.set(mergedIndex, leftElement);
                    leftIndex++;
                } else {
                    mergedList.set(mergedIndex, rightElement);
                    rightIndex++;
                }
            }
            else {
                if (compareTo(leftElement,rightElement) > 0) {
                    mergedList.set(mergedIndex, leftElement);
                    leftIndex++;
                } else {
                    mergedList.set(mergedIndex, rightElement);
                    rightIndex++;
                }
            }
            mergedIndex++;
        }

        while (leftIndex < leftSize) {
            mergedList.set(mergedIndex, leftList.get(leftIndex));
            leftIndex++;
            mergedIndex++;
        }
        while (rightIndex < rightSize) {
            mergedList.set(mergedIndex,rightList.get(rightIndex));
            rightIndex++;
            mergedIndex++;
        }
    }

    public int compareTo(E item1, E item2) {
        String item1String = item1.toString();
        String item2String = item2.toString();
        int compareVariable = Integer.valueOf(item1String).compareTo(Integer.valueOf(item2String));

        if (compareVariable > 0) {
            return 1;
        }
        else if (compareVariable == 0) {
            return 0;
        }
        else {
            return -1;
        }
    }

    public void printList (LinkedList list, PrintWriter pWriter) {
        for (int i = 0; i < list.size(); i++) {
            pWriter.print(list.get(i) + " ");
            if (i != 0 && (i + 1) % 25 == 0) {
                pWriter.println();
                pWriter.flush();
            }
        }
        pWriter.println();
        System.out.println(inc++);
    }





}
