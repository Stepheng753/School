package Practice;

import Info.CarInfo;
import Info.PersonInfo;
import Practice.Student.UnderGrad;

/**
 * Program: Practice
 * Description : Practice
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 9/19/2019
 **/

public class Print
{
    public static void main(String[] args)
    {
        //Car Info Stuff
        CarInfo BlueCar = new CarInfo();
        BlueCar.setCarInfo("Toyota", "2011", "Carolla", "Silver");
        BlueCar.printCar("Password");

        CarInfo RedCar = new CarInfo();
        RedCar.setCarInfo("Toyota", "2008", "Camry", "Silver");
        RedCar.printCar("Passwordz");

        //Instance.PersonInfo Stuff
        PersonInfo Stephen = new PersonInfo();
        Stephen.setToday(9,25);
        Stephen.setInfo("Stephen", "Giang", "7480 Northrup Drive", "San Diego", "California",
                        02, 3, 2000);
        Stephen.printInfo("Passwordz");
        Stephen.deleteIdentity();
        Stephen.printInfo("Passwordz");
        Stephen.changeIdentity();
        Stephen.printInfo("Passwordz");


        PersonInfo Adelei = new PersonInfo();
        Adelei.setToday(9, 25);
        Adelei.setInfo("Adeleidia", "Alcantara", "10110 Caminto Zar", "San Diego", "California",
                        02, 1, 2000);
        Adelei.printInfo("Password");

        //UnderGrad
        UnderGrad StephenG = new UnderGrad();
        StephenG.setInfo(0,200,'n');
        StephenG.printInfo();
    }
}
