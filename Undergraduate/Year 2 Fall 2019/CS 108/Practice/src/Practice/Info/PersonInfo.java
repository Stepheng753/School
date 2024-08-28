package Info;

import java.lang.Math;
import java.util.Random;

public class PersonInfo
{
    String firstName,
            lastName,
            streetAddress,
            city,
            state,
            birthMonthStr,
            password;
    Integer dayOfBirth,
            monthOfBirth,
            yearOfBirth;
    public int today;
    double Age;
    private Integer SSN;
    Random Random = new Random();

    public PersonInfo()
    {
        this.firstName = "John";
        this.lastName = "Doe";
        this.streetAddress = "123 Any Street";
        this.city = "City";
        this.state = "State";

        this.dayOfBirth = 1;
        this.monthOfBirth = 1;
        monthConverter();
        this.yearOfBirth = 2000;
        this.today = 365;
    }

    public void monthConverter()
    {
        if (monthOfBirth == 1)
        {
            birthMonthStr = "January";
        }
        if (monthOfBirth == 2)
        {
            birthMonthStr = "February";
        }
        if (monthOfBirth == 3)
        {
            birthMonthStr = "March";
        }
        if (monthOfBirth == 4)
        {
            birthMonthStr = "April";
        }
        if (monthOfBirth == 5)
        {
            birthMonthStr = "May";
        }
        if (monthOfBirth == 6)
        {
            birthMonthStr = "June";
        }
        if (monthOfBirth == 7)
        {
            birthMonthStr = "July";
        }
        if (monthOfBirth == 8)
        {
            birthMonthStr = "August";
        }
        if (monthOfBirth == 9)
        {
            birthMonthStr = "September";
        }
        if (monthOfBirth == 10)
        {
            birthMonthStr = "October";
        }
        if (monthOfBirth == 11)
        {
            birthMonthStr = "November";
        }
        if (monthOfBirth == 12)
        {
            birthMonthStr = "December";
        }
    }

    public void setDayOfYear()
    {
        int j = 1;
        for (int i = 0; i < 31; i++)    //January
        {
            dayOfYear[0][i] = j;
            j++;
        }
        for (int i = 0; i < 28; i++)    //February
        {
            dayOfYear[1][i] = j;
            j++;
        }
        for (int i = 0; i < 31; i++)    //March
        {
            dayOfYear[2][i] = j;
            j++;
        }
        for (int i = 0; i < 30; i++)    //April
        {
            dayOfYear[3][i] = j;
            j++;
        }
        for (int i = 0; i < 31; i++)    //May
        {
            dayOfYear[4][i] = j;
            j++;
        }
        for (int i = 0; i < 30; i++)    //June
        {
            dayOfYear[5][i] = j;
            j++;
        }
        for (int i = 0; i < 31; i++)    //July
        {
            dayOfYear[6][i] = j;
            j++;
        }
        for (int i = 0; i < 31; i++)    //August
        {
            dayOfYear[7][i] = j;
            j++;
        }
        for (int i = 0; i < 30; i++)    //September
        {
            dayOfYear[8][i] = j;
            j++;
        }
        for (int i = 0; i < 31; i++)    //October
        {
            dayOfYear[9][i] = j;
            j++;
        }
        for (int i = 0; i < 30; i++)    //November
        {
            dayOfYear[10][i] = j;
            j++;
        }
        for (int i = 0; i < 31; i++)    //December
        {
            dayOfYear[11][i] = j;
            j++;
        }
    }

    private static boolean setPassword(String password)
    {
        if (password == "Passwordz")
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void setSSN()
    {
        SSN = 123456789;
    }

    private String getSSN(String password)
    {
        if (setPassword(password) == true)
        {
            String SocSecNum = SSN.toString();
            return (SocSecNum.substring(0,3) + '\u2014' + SocSecNum.substring(3,5) + '\u2014' + SocSecNum.substring(5,9));
        }
        else
        {
            return "Wrong Password";
        }
    }

    public void setInfo(String firstName, String lastName, String streetAddress, String city, String state,
                        Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;

        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        monthConverter();
        this.yearOfBirth = yearOfBirth;
        setSSN();
    }

    int [][] dayOfYear = new int[12][31];

    public double getAge()
    {
        setDayOfYear();
        Age = ((Math.abs(dayOfYear[monthOfBirth -1][dayOfBirth -1] - today)));
        Age /= 365;
        Age += (2019 - yearOfBirth);
        return Age;
    }
    public void setToday(int month, int day)
    {
        setDayOfYear();
        today = dayOfYear[month-1][day-1];
    }

    public void printInfo(String password)
    {
        System.out.println("Name:       " + firstName + '\u0020' + lastName);
        System.out.println("Address:    " + streetAddress);
        System.out.println("            " + city + ", " + state);

        System.out.println("Birthday:   " + birthMonthStr +  '\u0020' + dayOfBirth + ", " + yearOfBirth);
        System.out.format ("Age:        %2.3f \n", getAge());
        System.out.println("SSN:        " + getSSN(password));
        System.out.println();
    }

    public void deleteIdentity()
    {
        this.firstName = "John";
        this.lastName = "Doe";
        this.streetAddress = "123 Any Street";
        this.city = "City";
        this.state = "State";
        this.birthMonthStr = "Month";

        this.dayOfBirth = 1;
        this.monthOfBirth = 1;
        this.yearOfBirth = 2000;
        this.SSN = Random.nextInt(899999999 + 1) + 100000000;;
    }

    public void changeIdentity()
    {
        this.firstName = "Henry";
        this.lastName = "Smith";
        Integer changeAddress = Random.nextInt(99899 + 1) + 100;
        this.streetAddress = changeAddress.toString().concat(" Second Street");
        this.city = "New York";
        this.state = "New York";

        this.dayOfBirth = Random.nextInt(27 + 1) + 1;
        this.monthOfBirth = Random.nextInt(11 + 1) + 1;
        monthConverter();
        this.yearOfBirth = Random.nextInt(419 + 1)+ 1600;
        this.SSN = Random.nextInt(899999999 + 1) + 100000000;
    }


}
