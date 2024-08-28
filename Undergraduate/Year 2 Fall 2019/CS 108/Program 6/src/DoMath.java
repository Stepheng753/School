public interface DoMath <T>
{

    /**
     * Finds Sum of all monthlySales within Time Frame ( Year or Quarter)
     * @return double
     */
    public double getSum();


    /**
     * Finds Average of all monthlySales within Time Frame ( Year or Quarter)
     * @return double
     */
    public double getAverage();

    /**
     * Finds Median of all monthlySales within Time Frame ( Year or Quarter)
     * @return double
     */
    public double getMedian();


    /**
     * Finds the Max
     * @return double
     */
    public double getMax();


    /**
     * Finds the Min
     * @return double
     */
    public double getMin();


    /**
     * Prints out changes from month to month and Average Change
     */
    public void getChange();


    /**
     * Prints any Statement using generics
     * @param printStatement
     */
    public void Print(T printStatement);


    /**
     * Prints any Statement using generics
     * @param printStatement,value
     */
    public void Print(T printStatement, double value);










}
