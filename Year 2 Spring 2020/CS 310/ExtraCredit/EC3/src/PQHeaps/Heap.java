package PQHeaps;
import java.util.*;
public class Heap {

    private int[] array;
    private int lastIndex;

    public Heap() {
        array =new int[1];
        lastIndex =0;
        array[0] = 2147483647;
    }

    public Heap(int maxSize) {
        array = new int[maxSize+1];
        lastIndex = 0;
        array[0] = 2147483647;
    }

    public void insertItem(int value)
    {
        lastIndex++;
        array[lastIndex]=value;
        upHeap(lastIndex);
    }

    private void upHeap(int i) {
        int k= array[i];
        int iparent = i/2;
        while(array[iparent] < k) {
            array[i]= array[iparent];
            i=iparent;
            iparent=i/2;
        }
        array[i]=k;
    }

    public int removeMax() {
        if(lastIndex ==0) {
            throw new NoSuchElementException("Heap is Empty!!");
        }

        int maxValue = array[1];
        array[1] = array[lastIndex];
        lastIndex--;
        downHeap(1);
        return maxValue;
    }

    public void downHeap(int i) {
        int k= array[i];
        int left=2*i;
        int right=left+1;

        while (right <= lastIndex) {
            if(k >= array[left]&& k >= array[right]) {
                array[i]=k;
                return;
            }
            else if(array[left] < array[right]) {
                array[i]= array[right];
                i=right;
            }
            else {
                array[i]= array[left];
                i=left;
            }
            left=2*i;
            right=left+1;
        }

        /* If number of nodes is even there is one node without right child */
        if(left == lastIndex && k < array[left]) {
            array[i]= array[left];
            i=left;
        }
        array[i]=k;
    }

    public void maxHeapify(int Arr[ ] , int rootIndex, int heapSize) {
        int left  = 2*rootIndex + 1;
        int right = 2*rootIndex + 2;
        int largest = rootIndex;
        if(left < heapSize && Arr[left] > Arr[largest] )
            largest = left;
        else
            largest = rootIndex;
        if(right < heapSize && Arr[right] > Arr[largest] )
            largest = right;
        if(largest != rootIndex) {
            int temp = Arr[rootIndex];
            Arr[rootIndex] = Arr[largest];
            Arr[largest] = temp;
            maxHeapify(Arr, largest,heapSize);
        }
    }

    public void buildHeap (int [] arr) {
        int heapsize = arr.length;
        int start = (heapsize / 2) - 1;
        for (int i = start; i >= 0; i--) {
            maxHeapify(arr,i,heapsize);
        }
    }

    @Override
    public String toString() {
        String print = "Heap: [ ";
        for (int i = 1; i < lastIndex; i++) {
            print = print.concat(array[i] + ", ");
        }
        print = print.concat(array[lastIndex] + " ]");

        return print;
    }

    public static void main (String[] args) {
        int size = 10;
        Heap heap = new Heap(size);
        int [] array = new int [size];
        for (int i = 0; i < size; i++) {
            heap.insertItem(i);
            array[i] = i;
        }
        System.out.println("Items inserted in the following order: " + printArray(array));
        System.out.println(heap);
        heap.removeMax();
        System.out.println("Max Deleted: " + heap);

        System.out.println("\nOriginal Array: " + printArray(array));
        heap.buildHeap(array);
        System.out.println("Array Heapified: " + printArray(array));
    }

    public static String printArray(int[] array) {
        String print = "[ ";
        for (int i = 0; i < array.length - 1; i++) {
            print = print.concat(array[i] + ", ");
        }
        print = print.concat(array[array.length - 1] + " ]");

        return print;

    }

}



