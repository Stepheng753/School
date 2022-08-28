
import java.util.Scanner;
import java.lang.String;
public class Populations1
{

    public static void printHeader()
    {
        System.out.printf("%-15s%-15s%-15s%-15s\n", "City", "Country", "Population", "Percent");
        System.out.println("________________________________________________________");

    }

    public static void addSpaces(String word)
    {
        char space = '\u0020';
        for (int i =0; i < 16 - word.length(); i++)
            System.out.print(space);
    }

    public static void addSpaces()
    {
        char space = '\u0020';
        for (int i =0; i < 4; i++)
            System.out.print(space);
    }

    public static void getIdentificationString()
    {
        System.out.println("Program 1, Stephen Giang");
    }

    public static String [] getCities()
    {
        String cities[] =
              { "Shanghai",
                "BEIJING",
                "Karachi",
                "Istanbul",
                "DHAKA",
                "TOKYO",
                "MOSCOW",
                "MANILA",
                "Tianjin",
                "Mumbai",
                "Sao Paulo",
                "Shenzhen",
                "Guangzhou",
                "DELHI",
                "Wuhan",
                "Lahore",
                "Seoul",
                "Chengdu",
                "KINSHASA",
                "LIMA"};

        return cities;
    }

    public static String [] getCountries()
    {
        String countries [] =
              { "China",
                "China",
                "Pakistan",
                "Turkey",
                "Bangladesh",
                "Japan",
                "Russia",
                "Philippines",
                "China",
                "India",
                "Brazil",
                "China",
                "China",
                "India",
                "China",
                "Pakistan",
                "South Korea",
                "China",
                "Congo D.R.",
                "Peru"};

        return countries;
    }

    public static double [][] getPopulations()
    {
        double populations [][] = {
              { 24153000.0,
                18590000,
                18000000,
                14657000,
                14543000,
                13617000,
                13197596,
                12877000,
                12784000,
                12400000,
                12038000,
                11908000,
                11548000,
                11035000,
                10608000,
                10355000,
                10290000,
                10152000,
                10125000,
                9752000},
                      { 1384688986,
                        1384688986,
                        207862518,
                        81257239,
                        162951560,
                        126168156,
                        143964513,
                        105920222,
                        1384688986,
                        1296834042,
                        207652865,
                        1384688986,
                        1384688986,
                        1296834042,
                        1384688986,
                        207862518,
                        50791919,
                        1384688986,
                        86300000,
                        31773839}};

        return populations;
    }

    public static void printStats(String [] cities, String [] countries, double [][] populations)
    {
        for (int i = 0; i < 19; i++ )
        {
            System.out.print(cities[i]);
            addSpaces(cities[i]);
            System.out.print(countries[i]);
            addSpaces(countries[i]);
            System.out.printf("%,-13.0f" , populations[0][i]);
            addSpaces();
            System.out.printf("%6.3f" , ((populations[0][i] / populations[1][i])*100));
            System.out.println();
        }
    }


    public static void main (String[] args)
    {
        printHeader();
        getCities();
        getCountries();
        getPopulations();
        printStats(getCities(), getCountries(), getPopulations());
    }
}
