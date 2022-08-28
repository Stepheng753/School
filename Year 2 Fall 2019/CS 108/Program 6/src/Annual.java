
public class Annual extends MonthsGroups implements DoMath
{

    /**
     * Sets the monthlySalesQueue from input from a keyboard
     */
    public Annual() {
        setMonthlySalesQueue();
    }


    /**
     * Sets the monthlySalesQueue from an array of Sales
     */
    public Annual(double[] salesPerMonthArray) throws Exception {
        this.salesPerMonthArray = salesPerMonthArray;
        setMonthlySalesQueue(this.salesPerMonthArray);
    }


    /**
     * Sets the monthlySalesQueue from input from a keyboard
     */
    @Override
    public void setMonthlySalesQueue() {
        setMonths();        // Sets the Months Array to the correct Months (Time Frame)
        // Asks use for input of Sales and adds it into monthlySalesQueue
        for (int i = 0; i < months.length; i++){
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
        // Makes Sure array length is of size of months
        if (salesPerMonth.length != 12) {
            System.out.println("Please Check Array Length");
            throw new Exception();
        }

        // Adds array values to monthlySalesQueue
        for (int i = 0; i < 12; i++) {
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
            return sum/12;
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
        int i = 0;          // Counter of each element
        double median = 0;  // Initializes median to 0
        while (!ascendStack.isEmpty()) {
            if (i == 5) {
                median = ascendStack.peek();    // First Middle Value
            }
            if (i == 6) {
                median += ascendStack.peek();   // adds Second Median Value
                median /= 2.0;                    // divides by 2 to Calculates Average
            }
            ascendStack.pop();                  // Removes values so I can traverse through Queue
            i++;                                // Increment counter
        }
        ascendSorted = false;                   // Shows that the ascendStack has been modified
        return Math.round(median*100)/100.0;
    }


    /**
     * Finds the Max
     * @return double
     */
    public double getMax() {
        if (ascendSorted == true) {
            return ascendStack.peek();      // Returns the top of the Ascended Stack or the Max
        }
        else {
            ascendSort();                   // Ascends Sorts
            return getMax();                // Recalls itself
        }
    }


    /**
     * Finds the Min
     * @return double
     */
    public double getMin() {
        return descendSort().peek();        // Returns the top of the Descended Stack or the Min
    }


    /**
     * Prints out changes from month to month and Average Change
     */
    public void getChange() {
        setMonths();
        double[] change = new double[11];
        double[] monthlySalesArray = new double[12];
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

        // Avg = sum / 11
        averageChange = sumChange / 11;

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
    public void Print(Object printStatement) {
        System.out.println(printStatement);
    }


    /**
     * Prints any Statement using generics with formatting
     * @param printStatement,value
     */
    public void Print(Object printStatement, double value) {
        System.out.format(printStatement + "$%.2f",value);
        System.out.println();
    }


}
