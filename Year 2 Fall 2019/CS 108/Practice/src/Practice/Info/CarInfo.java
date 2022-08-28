package Info;

public class CarInfo
{
    String make,
            year,
            model,
            color,
            licencePlate;
    private String password;

    public CarInfo()
    {
        this.make = "Make";
        this.year = "Year";
        this.model = "Model";
        this.color = "Color";
        this.licencePlate = "null";
    }

    public void setCarInfo(String make, String year, String model, String color)
    {
        this.make = make;
        this.year = year;
        this.model = model;
        this.color = color;
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

    private String getLicensePlate(String password)
    {
        if (setPassword(password) == true)
        {
            return licencePlate = "6TJV035";
        }
        else
        {
            return "Wrong Password";
        }
    }

    public void printCar(String password)
    {
        System.out.println("Make: " + make);
        System.out.println("Year: " + year);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("License Plate: " + getLicensePlate(password));
        System.out.println();
    }

}
