
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Scanner;

abstract public class MonthsGroups {

    Scanner input = new Scanner(System.in);                 // Input Scanner
    Queue<Double> monthlySalesQueue = new LinkedList<>();   // Will Hold All Sales for Each Month
    Stack<Double> ascendStack = new Stack<>();              // Will Hold Sales in Ascending Order
    Stack<Double> descendStack = new Stack<>();             // Will Hold Sales in Descending Order

    boolean ascendSorted = false;           // See if ascendSort was called
    boolean sumCalled = false;              // See if sum was calculated yet
    double sum;                             // Sum initialized
    String [] months = new String [12];     // Array to hold the months
    double [] salesPerMonthArray;           // Array to hold Sales Per Month

    /**
     * This will reset the months array back to correct order
     */
    public void setMonths() {
        months = new String[]{"January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"};
    }


    /**
     * This will have user plug in Sales for each Month
     */
    public abstract void setMonthlySalesQueue();


    /**
     * This will have populate the Monthly Sales with an array Parameter
     * @param salesPerMonth
     */
    public abstract void setMonthlySalesQueue(double [] salesPerMonth) throws Exception;


    /**
     * This will return the monthlySalesQueue in ascending order
     * @return Stack<Double>
     */
    public Stack<Double> ascendSort(){

        ascendStack.clear();    // Clears the Ascended Stack because it gets modified through the program
        setMonths();            // This resets the months after modification
        double [] ascendArray = new double [monthlySalesQueue.size()];  // Creates an ascending array for swapping

        // Populates ascendArray with elements of monthlySalesQueue without modifying monthlySalesQueue
        for (int i = 0; i < ascendArray.length; i++){
            ascendArray[i] = monthlySalesQueue.poll();  // Adds monthlySalesQueue Element then removes it
            monthlySalesQueue.add(ascendArray[i]);      // After removable of Element, adds it back into monthlySalesQueue
        }

        for (int i = 0; i < ascendArray.length - 1; i++){
            for (int j = i+1; j < ascendArray.length; j++){
                // Swap if next element is bigger
                if (ascendArray[i] > ascendArray[j]){
                    double small = ascendArray[i];
                    ascendArray[i] = ascendArray[j];
                    ascendArray[j] = small;

                    // Moves the Months corresponding to the moving of Array Elements
                    String corrMonth = months[i];
                    months[i] = months[j];
                    months[j] = corrMonth;
                }
            }
        }

        // Populates the ascendStack with each Element in ascending order
        for (int i = 0; i < ascendArray.length; i++){
            ascendStack.add(ascendArray[i]);
        }

        ascendSorted = true;    // Allows us to track if already in ascendingOrder
        return ascendStack;
    }


    /**
     * This will return the monthlySalesQueue in descending order
     * @return Stack<Double>
     */
    public Stack<Double> descendSort() {

        descendStack.clear();       // Clears the Descended Stack because it gets modified through the program

        if (ascendSorted == true) {     // If already sorted, just do as below
            // Takes the ascendedStack and pops off the last one (Greatest Element) and adds to descendStack
            while (!ascendStack.isEmpty()) {
                descendStack.add(ascendStack.pop());
            }
            reverseArray(months);       // Reverses Months array (which is in ascending order of monthlySales)
            ascendSorted = false;       // Tells that ascendStack is now Empty after popping all elements off
            return descendStack;
        }
        else {
            ascendSort();               // If not in ascending order, ascendSort it
            return descendSort();       // Now that its in ascending order, go back to the top
        }

    }


    /**
     * Prints all Monthly Sales with each Month
     */
    public void Print() {
        System.out.println(months.length + " Months of Sales: ");
        for (int i = 0; i < months.length; i++){
            double monthSale = monthlySalesQueue.poll();        // Holds element from monthlySalesQueue, and then removes it
            monthlySalesQueue.add(monthSale);                   // After removal, adds it back in monthlySalesQueue
            System.out.println(months[i] + ": " + monthSale);   // Print month: monthlySale
        }
    }


    /**
     * Returns the Month that corresponds to the specified monthlySale, FAST
     * @param specMonthlySale
     * @return String
     */
    public String binarySearch(double specMonthlySale) {
        // ascendSorts MonthlySales if not in ascending order
        if (ascendSorted == false) {
            ascendSort();
        }
        double [] searchArray = new double [ascendStack.size()];    // Creates a searchArray for swapping
        // Populates searchArray with ascendStack elements (searchArray becomes also in ascending order)
        for (int i = searchArray.length - 1; i >= 0; i--) {
            searchArray[i] = ascendStack.pop();
        }
        ascendSorted = false;

        int mid = 0;
        int low = 0;
        int high = searchArray.length - 1;
        while (high >= low) {
            mid = (high + low) / 2;     // Takes the middle index of Array
            // If the specified monthlySale is on the 'right half', research the 'right' half
            if (searchArray[mid] < specMonthlySale) {
                low = mid + 1;
            }
            // If the specified monthlySale is on the 'left' half, research the 'left' half
            else if (searchArray[mid] > specMonthlySale) {
                high = mid - 1;
            }
            // If the specified monthlySale is on neither side, then mid = index of specified monthlySale
            else {
                return months[mid];     // Returns the month at index, to see when the company made the specified monthlySale
            }
        }
        return "Not Found";     // If specified monthlySale is not in array, then high < low, and exits while loop

    }


    /**
     * Returns the Month that corresponds to the specified monthlySale, SLOW
     * @param specMonthlySale
     * @return String
     */
    public String linearSearch (double specMonthlySale) {
        setMonths();
        String month = "Not Found";                 // If not found, will return "Not Found"

        // Goes through all elements and stops when found
        for (int i = 0; i < monthlySalesQueue.size(); i++) {
            double monthSale = monthlySalesQueue.poll();    // Holds the removed value from monthlySalesQueue
            monthlySalesQueue.add(monthSale);               // Adds it back in to avoid any modification
            if (monthSale == specMonthlySale) {
                month =  months[i];                         // If found, set the return value to the month at that index
            }
        }
        return month;
    }


    /**
     * Prints arrays to [ element, element, ... , element ]
     * @param array
     * @return String
     */
    public String toString(String [] array){
        String arrayStr = "[ ";         // Starts the method with '[ '
        // Prints out each element with a comma and a space following
        for (int i = 0; i < array.length - 1; i++) {
            arrayStr += array[i] + ", ";
        }
        // Prints out last element without a comma
        arrayStr += array[array.length - 1] + " ]";
        return arrayStr;
    }


    /**
     * Reverses the Array [1, 2, 3] -> [3, 2, 1]
     * @param array
     */
    public void reverseArray (String [] array) {
        int first = 0;                  // First Index
        int last = array.length - 1;    // Last Index
        // Swaps the First and Last, then Second and Second to Last and ...
        while (first < last) {
            String swapHolder = array[first];
            array[first] = array[last];
            array[last] = swapHolder;
            first++;        // Turns the first to the second to ...
            last--;         // Turns the last to the second to last to ...
        }
    }







}
