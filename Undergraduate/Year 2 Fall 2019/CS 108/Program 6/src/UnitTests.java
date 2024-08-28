
public class UnitTests
{
    // Sum = 52
    // Median = 5
    // Max = 9
    // Min = -1
    static double [] year1SalesArray = {1, 3, 4, 6,
                                        6, 6, 6, 8,
                                        9, 2, 2, -1};

    // Sum = 541235
    // Median = 33374.59
    // Max = 99999.99
    // Min = 12301.23
    static double [] year2SalesArray = {12301.23, 25284.25, 25492.20, 24549.23,
                                        12356.87, 98756.65, 45698.24, 41256.98,
                                        99999.99, 21546.25, 78456.35, 55542.24};

    // Sum = 2500
    // Median = 1000
    // Max = 1000
    // Min = 500
    static double [] Q1SalesArray = {1000, 1000, 500};

    // Sum = 90503.78
    // Median = 26262.26
    // Max = 54216.26
    // Min = 10025.26
    static double [] Q2SalesArray = {54216.26, 10025.26, 26262.26};


    public static void main(String[] args) throws Exception {
        Annual year1 = new Annual(year1SalesArray);
        Annual year2 = new Annual(year2SalesArray);
        Quarter Q1 = new Quarter(1, Q1SalesArray);
        Quarter Q2 = new Quarter(2, Q2SalesArray);

        binarySearchFoundTest(year1, 8);
        binarySearchNotFoundTest(year1, 2015487.26);
        linearSearchFoundTest(year1, 6);
        linearSearchNotFoundTest(year1, 15469.215);
        ascendSortTest(year1);
        descendSortTest(year1);
        getSumTest(year1, 52);
        getAverageTest(year1, 52);
        getMedianTest(year1, 5.0);
        getMaxTest(year1, 9);
        getMinTest(year1, -1);

        System.out.println("/---------------------------------------/\n");

        binarySearchFoundTest(year2, 12356.87);
        binarySearchNotFoundTest(year2, 2015487.26);
        linearSearchFoundTest(year2, 45698.24);
        linearSearchNotFoundTest(year2, 15469.215);
        ascendSortTest(year2);
        descendSortTest(year2);
        getSumTest(year2, 541240.48);
        getAverageTest(year2, 541240.48);
        getMedianTest(year2, 33374.59);
        getMaxTest(year2, 99999.99);
        getMinTest(year2, 12301.23);

        System.out.println("/---------------------------------------/\n");

        binarySearchFoundTest(Q1, 1000);
        binarySearchNotFoundTest(Q1, 2015487.26);
        linearSearchFoundTest(Q1, 500);
        linearSearchNotFoundTest(Q1, 15469.215);
        ascendSortTest(Q1);
        descendSortTest(Q1);
        getSumTest(Q1, 2500);
        getAverageTest(Q1, 2500);
        getMedianTest(Q1, 1000);
        getMaxTest(Q1, 1000);
        getMinTest(Q1, 500);

        System.out.println("/---------------------------------------/\n");

        binarySearchFoundTest(Q2, 26262.26);
        binarySearchNotFoundTest(Q2, 2015487.26);
        linearSearchFoundTest(Q2, 54216.26);
        linearSearchNotFoundTest(Q2, 15469.215);
        ascendSortTest(Q2);
        descendSortTest(Q2);
        getSumTest(Q2, 90503.78);
        getAverageTest(Q2, 90503.78);
        getMedianTest(Q2, 26262.26);
        getMaxTest(Q2, 54216.26);
        getMinTest(Q2, 10025.26);

    }

    /**
     * Tests if Binary Search Finds a Certain Sale, that is within the MonthlySalesQueue
     * @param fiscal
     * @param searchSale
     */
    public static void binarySearchFoundTest(Annual fiscal, double searchSale) {
        if (fiscal.binarySearch(searchSale).contains("Not Found")) {
            System.out.println("Binary Search Found Test: Wrong!");
            fiscal.Print("Your Sale was Not Found!");
            System.out.println();
        }
        else {
            System.out.println("Binary Search Found Test: Correct!");
            fiscal.Print("Your Sale was $" + searchSale + " in: " + fiscal.binarySearch(searchSale));
            System.out.println();
        }
    }

    /**
     * Tests if Binary Search Finds a Certain Sale, that is within the MonthlySalesQueue
     * @param quarter
     * @param searchSale
     */
    public static void binarySearchFoundTest(Quarter quarter, double searchSale) {
        if (quarter.binarySearch(searchSale).contains("Not Found")) {
            System.out.println("Binary Search Found Test: Wrong!");
            quarter.Print("Your Sale was Not Found!");
            System.out.println();
        }
        else {
            System.out.println("Binary Search Found Test: Correct!");
            quarter.Print("Your Sale was $" + searchSale + " in: " + quarter.binarySearch(searchSale));
            System.out.println();
        }
    }


    /**
     * Tests if Binary Search returns "Not Found" if the Sale is not within MonthlySalesQueue
     * @param fiscal
     * @param saleUnfounded
     */
    public static void binarySearchNotFoundTest (Annual fiscal, double saleUnfounded) {
        if (fiscal.binarySearch(saleUnfounded).contains("Not Found")) {
            System.out.println("Binary Search Not Found Test: Correct!");
            fiscal.Print("Your Sale of $" + saleUnfounded + " was : " + fiscal.binarySearch(saleUnfounded));
            System.out.println();
        }
        else {
            System.out.println("Binary Search Not Found Test: Wrong!");
            fiscal.Print("Your Sale of $" + saleUnfounded + " was found in: " + fiscal.binarySearch(saleUnfounded));
            System.out.println();
        }
    }

    /**
     * Tests if Binary Search returns "Not Found" if the Sale is not within MonthlySalesQueue
     * @param quarter
     * @param saleUnfounded
     */
    public static void binarySearchNotFoundTest (Quarter quarter, double saleUnfounded) {
        if (quarter.binarySearch(saleUnfounded).contains("Not Found")) {
            System.out.println("Binary Search Not Found Test: Correct!");
            quarter.Print("Your Sale of $" + saleUnfounded + " was : " + quarter.binarySearch(saleUnfounded));
            System.out.println();
        }
        else {
            System.out.println("Binary Search Not Found Test: Wrong!");
            quarter.Print("Your Sale of $" + saleUnfounded + " was found in: " + quarter.binarySearch(saleUnfounded));
            System.out.println();
        }
    }


    /**
     * Tests if Linear Search Finds a Certain Sale, that is within the MonthlySalesQueue
     * @param fiscal
     * @param searchSale
     */
    public static void linearSearchFoundTest (Annual fiscal, double searchSale) {
        if (fiscal.linearSearch(searchSale).contains("Not Found")) {
            System.out.println("Linear Search Found Test: Wrong!");
            fiscal.Print("Your Sale was Not Found!");
            System.out.println();
        }
        else {
            System.out.println("Linear Search Found Test: Correct!");
            fiscal.Print("Your Sale was $" + searchSale + " in: " + fiscal.linearSearch(searchSale));
            System.out.println();
        }
    }

    /**
     * Tests if Linear Search Finds a Certain Sale, that is within the MonthlySalesQueue
     * @param quarter
     * @param searchSale
     */
    public static void linearSearchFoundTest (Quarter quarter, double searchSale) {
        if (quarter.linearSearch(searchSale).contains("Not Found")) {
            System.out.println("Linear Search Found Test: Wrong!");
            quarter.Print("Your Sale was Not Found!");
            System.out.println();
        }
        else {
            System.out.println("Linear Search Found Test: Correct!");
            quarter.Print("Your Sale was $" + searchSale + " in: " + quarter.linearSearch(searchSale));
            System.out.println();
        }
    }


    /**
     * Tests if Linear Search returns "Not Found" if the Sale is not within MonthlySalesQueue
     * @param fiscal
     * @param saleUnfounded
     */
    public static void linearSearchNotFoundTest (Annual fiscal, double saleUnfounded) {
        if (fiscal.linearSearch(saleUnfounded).contains("Not Found")) {
            System.out.println("Linear Search Not Found Test: Correct!");
            fiscal.Print("Your Sale of $" + saleUnfounded + " was : " + fiscal.linearSearch(saleUnfounded));
            System.out.println();
        }
        else {
            System.out.println("Linear Search Not Found Test: Wrong!");
            fiscal.Print("Your Sale of $" + saleUnfounded + " was found in: " + fiscal.linearSearch(saleUnfounded));
            System.out.println();
        }
    }

    /**
     * Tests if Linear Search returns "Not Found" if the Sale is not within MonthlySalesQueue
     * @param quarter
     * @param saleUnfounded
     */
    public static void linearSearchNotFoundTest (Quarter quarter, double saleUnfounded) {
        if (quarter.linearSearch(saleUnfounded).contains("Not Found")) {
            System.out.println("Linear Search Not Found Test: Correct!");
            quarter.Print("Your Sale of $" + saleUnfounded + " was : " + quarter.linearSearch(saleUnfounded));
            System.out.println();
        }
        else {
            System.out.println("Linear Search Not Found Test: Wrong!");
            quarter.Print("Your Sale of $" + saleUnfounded + " was found in: " + quarter.linearSearch(saleUnfounded));
            System.out.println();
        }
    }


    /**
     * Tests whether each element is bigger than the next
     * @param fiscal
     */
    public static void ascendSortTest (Annual fiscal) {
        double [] ascendArray = new double [12];
        boolean correct = true;

        for (int i = ascendArray.length - 1; i >= 0; i--) {
            ascendArray[i] = fiscal.ascendSort().pop();
        }

        for (int i = 0; i < ascendArray.length - 1; i++) {
            if (ascendArray[i] > ascendArray[i+1]) {
                correct = false;
                System.out.println("Ascend Sort Test: Wrong!");
                System.out.println(ascendArray[i] + " is Greater than " + ascendArray[i+1]);
                System.out.println();
            }
        }

        if (correct == true) {
            System.out.println("Ascend Sort Test: Correct!");
            fiscal.Print("Ascend: " + fiscal.ascendSort());
            System.out.println();
        }
    }

    /**
     * Tests whether each element is bigger than the next
     * @param quarter
     */
    public static void ascendSortTest (Quarter quarter) {
        double [] ascendArray = new double [12];
        boolean correct = true;

        for (int i = ascendArray.length - 1; i >= 0; i--) {
            ascendArray[i] = quarter.ascendSort().pop();
        }

        for (int i = 0; i < ascendArray.length - 1; i++) {
            if (ascendArray[i] > ascendArray[i+1]) {
                correct = false;
                System.out.println("Ascend Sort Test: Wrong!");
                System.out.println(ascendArray[i] + " is Greater than " + ascendArray[i+1]);
                System.out.println();
            }
        }

        if (correct == true) {
            System.out.println("Ascend Sort Test: Correct!");
            quarter.Print("Ascend: " + quarter.ascendSort());
            System.out.println();
        }
    }


    /**
     * Tests whether each element is smaller than the next
     * @param fiscal
     */
    public static void descendSortTest (Annual fiscal) {
        double [] descendArray = new double [12];
        boolean correct = true;

        for (int i = descendArray.length - 1; i >= 0; i--) {
            descendArray[i] = fiscal.descendSort().pop();
        }

        for (int i = 0; i < descendArray.length - 1; i++) {
            if (descendArray[i] < descendArray[i+1]) {
                correct = false;
                System.out.println("Descend Sort Test: Wrong!");
                System.out.println(descendArray[i] + " is Less than " + descendArray[i+1]);
                System.out.println();
            }
        }

        if (correct == true) {
            System.out.println("Descend Sort Test: Correct!");
            fiscal.Print("Descend: " + fiscal.descendSort());
            System.out.println();
        }
    }

    /**
     * Tests whether each element is smaller than the next
     * @param quarter
     */
    public static void descendSortTest (Quarter quarter) {
        double [] descendArray = new double [12];
        boolean correct = true;

        for (int i = descendArray.length - 1; i >= 0; i--) {
            descendArray[i] = quarter.descendSort().pop();
        }

        for (int i = 0; i < descendArray.length - 1; i++) {
            if (descendArray[i] < descendArray[i+1]) {
                correct = false;
                System.out.println("Descend Sort Test: Wrong!");
                System.out.println(descendArray[i] + " is Less than " + descendArray[i+1]);
                System.out.println();
            }
        }

        if (correct == true) {
            System.out.println("Descend Sort Test: Correct!");
            quarter.Print("Descend: " + quarter.descendSort());
            System.out.println();
        }
    }


    /**
     * Check the getSum method with the actual Sum
     * @param fiscal
     * @param actualSum
     */
    public static  void getSumTest (Annual fiscal, double actualSum) {
        if (fiscal.getSum() == actualSum) {
            System.out.println("Get Sum Test: Correct!");
            System.out.println("Sum: " + fiscal.getSum());
            System.out.println();
        }
        else {
            System.out.println("Get Sum Test: Wrong!");
            System.out.println("Sum should have been: " + actualSum);
            System.out.println("Your Sum: " + fiscal.getSum());
            System.out.println();
        }
    }

    /**
     * Check the getSum method with the actual Sum
     * @param quarter
     * @param actualSum
     */
    public static  void getSumTest (Quarter quarter, double actualSum) {
        if (quarter.getSum() == actualSum) {
            System.out.println("Get Sum Test: Correct!");
            System.out.println("Sum: " + quarter.getSum());
            System.out.println();
        }
        else {
            System.out.println("Get Sum Test: Wrong!");
            System.out.println("Sum should have been: " + actualSum);
            System.out.println("Your Sum: " + quarter.getSum());
            System.out.println();
        }
    }


    /**
     * Check the getAverage method with the actual Average
     * @param fiscal
     * @param actualSum
     */
    public static void getAverageTest (Annual fiscal, double actualSum) {
        if (fiscal.getAverage() == actualSum/12.0) {
            System.out.println("Get Average Test: Correct!");
            System.out.format("Average: $%.2f\n" , fiscal.getAverage());
            System.out.println();
        }
        else {
            System.out.println("Get Average Test: Wrong!");
            System.out.format("Average should have been: $%.2f\n", actualSum/12.0);
            System.out.println("Your Average: " + fiscal.getAverage());
            System.out.println();
        }
    }

    /**
     * Check the getAverage method with the actual Average
     * @param quarter
     * @param actualSum
     */
    public static void getAverageTest (Quarter quarter, double actualSum) {
        if (quarter.getAverage() == actualSum/3.0) {
            System.out.println("Get Average Test: Correct!");
            System.out.println("Average: " + quarter.getAverage());
            System.out.println();
        }
        else {
            System.out.println("Get Average Test: Wrong!");
            System.out.format("Average should have been: $%.2f\n", actualSum/3.0);
            System.out.println("Your Average: " + quarter.getAverage());
            System.out.println();
        }
    }


    /**
     * Check the getMedian method with the actual Median
     * @param fiscal
     * @param actualMedian
     */
    public static void getMedianTest (Annual fiscal, double actualMedian) {
        if (fiscal.getMedian() == actualMedian) {
            System.out.println("Get Median Test: Correct!");
            System.out.println("Median: " + fiscal.getMedian());
            System.out.println();
        }
        else {
            System.out.println("Get Median Test: Wrong!");
            System.out.println("Your Median should have been: " + actualMedian);
            System.out.println("Your Median: " + fiscal.getMedian());
            System.out.println();
        }
    }

    /**
     * Check the getMedian method with the actual Median
     * @param quarter
     * @param actualMedian
     */
    public static void getMedianTest (Quarter quarter, double actualMedian) {
        if (quarter.getMedian() == actualMedian) {
            System.out.println("Get Median Test: Correct!");
            System.out.println("Median: " + quarter.getMedian());
            System.out.println();
        }
        else {
            System.out.println("Get Median Test: Wrong!");
            System.out.println("Your Median should have been: " + actualMedian);
            System.out.println("Your Median: " + quarter.getMedian());
            System.out.println();
        }
    }


    /**
     * Check the getMax method with the actual Max
     * @param fiscal
     * @param actualMax
     */
    public static void getMaxTest (Annual fiscal, double actualMax) {
        if (fiscal.getMax() == actualMax) {
            System.out.println("Get Max Test: Correct!");
            System.out.println("Max: " + fiscal.getMax());
            System.out.println();
        }
        else {
            System.out.println("Get Max Test: Wrong!");
            System.out.println("Your Max should have been: " + actualMax);
            System.out.println("Your Max: " + fiscal.getMax());
            System.out.println();
        }
    }

    /**
     * Check the getMax method with the actual Max
     * @param quarter
     * @param actualMax
     */
    public static void getMaxTest (Quarter quarter, double actualMax) {
        if (quarter.getMax() == actualMax) {
            System.out.println("Get Max Test: Correct!");
            System.out.println("Max: " + quarter.getMax());
            System.out.println();
        }
        else {
            System.out.println("Get Max Test: Wrong!");
            System.out.println("Your Max should have been: " + actualMax);
            System.out.println("Your Max: " + quarter.getMax());
            System.out.println();
        }
    }


    /**
     * Check the getMin method with the actual Min
     * @param fiscal
     * @param actualMin
     */
    public static void getMinTest (Annual fiscal, double actualMin) {
        if (fiscal.getMin() == actualMin) {
            System.out.println("Get Min Test: Correct!");
            System.out.println("Min: " + fiscal.getMin());
            System.out.println();
        } else {
            System.out.println("Get Min Test: Wrong!");
            System.out.println("Your Min should have been: " + actualMin);
            System.out.println("Your Min: " + fiscal.getMin());
            System.out.println();
        }
    }

    /**
     * Check the getMin method with the actual Min
     * @param quarter
     * @param actualMin
     */
    public static void getMinTest (Quarter quarter, double actualMin) {
        if (quarter.getMin() == actualMin) {
            System.out.println("Get Min Test: Correct!");
            System.out.println("Min: " + quarter.getMin());
            System.out.println();
        } else {
            System.out.println("Get Min Test: Wrong!");
            System.out.println("Your Min should have been: " + actualMin);
            System.out.println("Your Min: " + quarter.getMin());
            System.out.println();
        }
    }

}
