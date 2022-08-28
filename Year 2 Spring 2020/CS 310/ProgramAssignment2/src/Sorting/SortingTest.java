package Sorting;

import java.util.LinkedList;
import java.util.Random;

public class SortingTest<E> implements Sorting<E> {

    private int [] outputArray;

    public SortingTest () {
        outputArray = new int[] {10, 50, 100, 150, 300, 500, 1000, 1500};
    }

    public static void main(String[] args) {
        SortingTest <Integer> sorting = new SortingTest<Integer>();

        sorting.insertionTest(sorting, sorting.outputArray);
        sorting.quickTest(sorting, sorting.outputArray);
        sorting.mergeTest(sorting, sorting.outputArray);
    }

    private void insertionTest (SortingTest <Integer> sorting, int [] outputArray) {
        Random randomNum = new Random();
        System.out.println("------------------\n");
        LinkedList<Integer> list;

        for (int j = 0; j < outputArray.length; j++) {
            list = new LinkedList<>();
            for (int i = 0; i < outputArray[j]; i++) {
                list.add(randomNum.nextInt(outputArray[j]));
            }

            double start = System.nanoTime();
            sorting.insertionSort(list, 1, list.size() - 1, false);
            double end = System.nanoTime();
            System.out.println("\nInsertion Unsorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");

            start = System.nanoTime();
            sorting.insertionSort(list, 1, list.size() - 1, false);
            end = System.nanoTime();
            System.out.println("Insertion Sorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");

            start = System.nanoTime();
            sorting.insertionSort(list, 1, list.size() - 1, true);
            end = System.nanoTime();
            System.out.println("Insertion Reversed Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");

            System.out.println("\n------------------\n");
        }

    }

    private void quickTest (SortingTest <Integer> sorting, int [] outputArray) {
        Random randomNum = new Random();
        System.out.println("------------------\n");
        LinkedList<Integer> list;

        for (int j = 0; j < outputArray.length; j++) {
            list = new LinkedList<>();
            for (int i = 0; i < outputArray[j]; i++) {
                list.add(randomNum.nextInt(outputArray[j]));
            }

            double start = System.nanoTime();
            sorting.quickSort(list, 0, list.size() - 1, false);
            double end = System.nanoTime();
            System.out.println("\nQuick Unsorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");

            start = System.nanoTime();
            sorting.quickSort(list, 0, list.size() - 1, false);
            end = System.nanoTime();
            System.out.println("Quick Sorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");

            start = System.nanoTime();
            sorting.quickSort(list, 0, list.size() - 1, true);
            end = System.nanoTime();
            System.out.println("Quick Reversed Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");

            System.out.println("\n------------------\n");
        }
    }

    private void mergeTest (SortingTest <Integer> sorting, int [] outputArray) {
        Random randomNum = new Random();
        System.out.println("------------------\n");
        LinkedList<Integer> list;

        for (int j = 0; j < outputArray.length; j++) {
            list = new LinkedList<>();
            for (int i = 0; i < outputArray[j]; i++) {
                list.add(randomNum.nextInt(outputArray[j]));
            }

            double start = System.nanoTime();
            sorting.mergeSortLL(list, false);
            double end = System.nanoTime();
            System.out.println("\nMerge Unsorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");

            start = System.nanoTime();
            sorting.mergeSortLL(list, false);
            end = System.nanoTime();
            System.out.println("Merge Sorted Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");

            start = System.nanoTime();
            sorting.mergeSortLL(list, true);
            end = System.nanoTime();
            System.out.println("Merge Reversed Time for " + outputArray[j] + " outputs: " + (end - start) + " nanoseconds\n");

            System.out.println("\n------------------\n");
        }
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
            if (reversed == false) {
                int lastBiggerIndex = lowIndex;
                while (incrementer <= highIndex) {
                    if (compareTo(list.get(incrementer),pivot) > 0) {
                        incrementer++;
                    } else {
                        swap(list, incrementer, lastBiggerIndex);
                        incrementer++;
                        lastBiggerIndex++;
                    }
                }
                quickSort(list, lowIndex, lastBiggerIndex - 2, false);
                quickSort(list, lastBiggerIndex, highIndex, false);
            }
            else {
                int lastSmallerIndex = lowIndex;
                while (incrementer <= highIndex) {
                    if (compareTo(list.get(incrementer),pivot) < 0) {
                        incrementer++;
                    } else {
                        swap(list, incrementer, lastSmallerIndex);
                        incrementer++;
                        lastSmallerIndex++;
                    }
                }
                quickSort(list, lowIndex, lastSmallerIndex - 2, true);
                quickSort(list, lastSmallerIndex, highIndex, true);
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

    private int compareTo(E item1, E item2) {
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






}
