import java.text.DecimalFormat;

public class Quarter extends MonthsGroups implements DoMath {

    int quarter;        // Determines which Fiscal Quarter, or which months in the Year

    /**
     * Determine which quarter at call using Constructor
     * Sets the monthlySalesQueue from input from a keyboard
     * @param quarter
     */
    public Quarter(int quarter) throws Exception {
        // Throws Exception if not a valid Quarter
        if (quarter < 1 || quarter > 4) {
            System.out.println("Please Check if Quarter Number is Valid");
            throw new Exception();
        }
        this.quarter = quarter;
        setMonthlySalesQueue();
    }


    /**
     * Determine which quarter at call using Constructor
     * Sets the monthlySalesQueue from an array of Sales
     * @param quarter,salesPerMonth
     */
    public Quarter(int quarter, double [] salesPerMonthArray) throws Exception {
        // Throws Exception if not a valid Quarter
        if (quarter < 1 || quarter > 4) {
            System.out.println("Please Check if Quarter Number is Valid");
            throw new Exception();
        }
        this.quarter = quarter;
        this.salesPerMonthArray = salesPerMonthArray;
        setMonthlySalesQueue(this.salesPerMonthArray);
    }


    /**
     * Changes the months array (with all months) to an array with only the months in the quarter
     */
    @Override
    public void setMonths(){
        // Months of the Year
        months = new String[]{"January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"};

        String [] quarterMonths = new String [3];       // Only three months in a Quarter
        // Only keeps the Months of the quarter
        for (int i = 0; i < 3; i++) {
            quarterMonths[i] = months[3 * (quarter - 1) + i];
        }
        months = new String [3];    // Clears months array and resizes to 3
        months = quarterMonths;     // Changes the months array to specified months
    }


    /**
     * Sets the monthlySalesQueue from input from a keyboard
     */
    @Override
    public void setMonthlySalesQueue() {
        setMonths();        // Sets the Months Array to the correct Months (Time Frame)
        // Asks use for input of Sales and adds it into monthlySalesQueue
        for (int i = 0; i < 3; i++){
            System.out.print("Enter in Sales for " + months[i] + ": $");
            monthlySalesQueue.add(input.nextDouble());
        }
    }


    /**
     * Sets the monthlySalesQueue from an array of Sales
     * @param salesPerMonth
     */
    @Override
    public void setMonthlySalesQueue(double[] salesPerMonth) throws Exception {
        setMonths();        // Sets the Months Array to the correct Months (Time Frame)
        //Throws Exception if array size does not equal 3
        if (salesPerMonth.length != 3) {
            System.out.println("Please Check Array Length");
            throw new Exception();
        }

        // Adds array values to monthlySalesQueue
        for (int i = 0; i < 3; i++) {
            monthlySalesQueue.add(salesPerMonth[i]);
        }

    }

    // ---------------------------------------------------------------

    /**
     * Calculates Sum of all elements of monthlySalesQueue
     * @return double
     */
    @Override
    public double getSum() {
        sum = 0;        //Initializes it to 0
        // For each monthSale in monthlySalesQueue, add it into sum variable
        for (double monthSale: monthlySalesQueue){
            sum += monthSale;
        }

        sumCalled = true;   // Sum has been calculated
        return sum;
    }


    /**
     * Calculates Average of all the elements of monthlySalesQueue
     * @return double
     */
    @Override
    public double getAverage() {
        // If Sum has already been calculated, just divide that by 3 months
        if (sumCalled == true){
            return sum/3;
        }
        // Calculate Sum and then rerun the method
        else {
            getSum();
            return getAverage();
        }
    }


    /**
     * Calculates the Median of all the elements of monthlySalesQueue. If # of elements = even, take average of middle terms
     * @return
     */
    @Override
    public double getMedian() {
        if (ascendSorted == false) {
            ascendSort();       // To take median, must be in ascending order
        }
        double median = 0;  // Initializes median
        // Removes all the values in ascendStack, until it reaches the middle (i == 1), and that is the median.
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                median = ascendStack.peek();        // returns Middle Value
            }
            ascendStack.pop();                      // Removes values so I can traverse through Queue
        }
        ascendSorted = false;                       // Shows that the ascendStack has been modified
        return median;
    }


    /**
     * Finds the Max
     * @return double
     */
    public double getMax() {
        if (ascendSorted == true) {
            return ascendStack.peek();              // Returns the top of the Ascended Stack or the Max
        }
        else {
            ascendSort();                           // Ascends Sorts
            return getMax();                        // Recalls itself
        }
    }


    /**
     * Finds the Min
     * @return double
     */
    public double getMin() {
        return descendSort().peek();                // Returns the top of the Descended Stack or the Min
    }


    /**
     * Prints out changes from month to month and Average Change
     */
    public void getChange() {
        setMonths();
        double[] change = new double[2];
        double[] monthlySalesArray = new double[3];
        for (int i = 0; i < monthlySalesArray.length; i++) {
            monthlySalesArray[i] = monthlySalesQueue.poll();  // Adds monthlySalesQueue Element then removes it
            monthlySalesQueue.add(monthlySalesArray[i]);      // After removable of Element, adds it back into monthlySalesQueue
        }
        for (int i = 0; i < months.length - 1; i++) {
            // Change = difference between month;ySales
            change[i] = monthlySalesArray[i + 1] - monthlySalesArray[i];

            // If change = negative, Print decrease
            if (change[i] < 0) {
                System.out.println("Decrease from " + months[i] + " to " + months[i + 1] + " of : " + (change[i]*-1) + " dollars");
            }

            // If change = positive, Print increase
            else if (change[i] > 0) {
                System.out.println("Increase from " + months[i] + " to " + months[i + 1] + " of : " + change[i] + " dollars");
            }

            // If change = 0, Print no change
            else {
                System.out.println("No Change from " + months[i] + " to " + months[i + 1]);
            }
        }
        double averageChange;
        double sumChange = 0;

        // Takes Sum of all the change values
        for (int i = 0; i < change.length; i++) {
            sumChange += change[i];
        }

        // Avg = sum / 2
        averageChange = sumChange / 2;

        // If avg = negative, puts negative on outside of $
        if (averageChange < 0) {
            System.out.println("Average Change: -$" + (averageChange*-1));
        }
        else {
            System.out.println("Average Change: $" + averageChange);
        }
    }

    /**
     * Prints any Statement using generics
     * @param printStatement
     */
    @Override
    public void Print(Object printStatement) {
        System.out.println(printStatement);
    }


    /**
     * Prints any Statement using generics
     * @param printStatement,value
     */
    public void Print(Object printStatement, double value) {
        System.out.format(printStatement + "$%.2f",value);
        System.out.println();
    }

}
