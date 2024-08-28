public class Populations
{
    public static void printHeader()
    {
        System.out.printf("%-15s%-17s%-15s%-10s\n", "City", "Country", "Population", "Percent");
        System.out.println(repeat('\u2014', 54));
    }

   public static String repeat(char letter, int numOfLetters)
    {
        String repeatedStr = "";

        for (int i = 0; i < numOfLetters; i++)
        {
            repeatedStr = repeatedStr + letter;
        }
        return repeatedStr;
    }

    public static void printStats(String [] cities, double [][] populations)
    {
        for (int i = 0; i < 19; i++ )
        {
            System.out.format("%-32s", cities[i]);
            System.out.format("%,-10.0f", populations[i][0] );
            System.out.print(repeat('\u0020', 6));
            System.out.format("%6.3f", (populations[i][0] / populations[i][1])*100 );
            System.out.println();
        }
    }

    public static String getIdentificationString()
    {
        return "Program 1c, Stephen Giang";
    }

    public static double[][] getPopulations()
    {
        double populations [][] =
                {
                        {24153000, 1384688986},
                        {18590000, 1384688986},
                        {18000000, 207862518},
                        {14657000, 81257239},
                        {14543000, 162951560},
                        {13617000, 126168156},
                        {13197596, 143964513},
                        {12877000, 105920222},
                        {12784000, 1384688986},
                        {12400000, 1296834042},
                        {12038000, 207652865},
                        {11908000, 1384688986},
                        {11548000, 1384688986},
                        {11035000, 1296834042},
                        {10608000, 1384688986},
                        {10355000, 207862518},
                        {10290000, 50791919},
                        {10152000, 1384688986},
                        {10125000, 86300000},
                        {9752000, 31773839}
                };
        return populations;
    }

    public static String[] getCities()
    {
        String cities[] =
                    {   "Shanghai       China",
                        "BEIJING        China",
                        "Karachi        Pakistan",
                        "Istanbul       Turkey",
                        "DHAKA          Bangladesh",
                        "TOKYO          Japan",
                        "MOSCOW         Russia",
                        "MANILA         Philippines",
                        "Tianjin        China",
                        "Mumbai         India",
                        "Sao Paulo      Brazil",
                        "Shenzhen       China",
                        "Guangzhou      China",
                        "DELHI          India",
                        "Wuhan          China",
                        "Lahore         Pakistan",
                        "Seoul          South Korea",
                        "Chengdu        China",
                        "KINSHASA       Congo D.R.",
                        "LIMA,Peru"};

        return cities;
    }

    public static void main(String [] args)
    {
        printHeader();
        getCities();
        getPopulations();
        printStats(getCities(), getPopulations());
    }




}
