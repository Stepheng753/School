#include<iostream>

using namespace std;

struct Car

{
	char Car_manufacturer[50],
		 Model[50];

	int Year_of_Sale;
	double Sale_Price;
};

int main()
{

	Car UsersCar;
	Car CarArray[3];
	for (int i = 0; i < 3; i++)

	{
	
		cout << "Enter Manufactorer of Car: " << endl;
		cin >> UsersCar.Car_manufacturer;

		cout << "Enter Model of Car: " << endl;
		cin >> UsersCar.Model;

		cout << "Enter Year of Sale of Car: " << endl;
		cin >> UsersCar.Year_of_Sale;
		while (UsersCar.Year_of_Sale < 1885)
		{
			cout << "The First Car was made in 1885.  " << endl
				 << "Enter Real Year of Sale: " << endl;
			cin >> UsersCar.Year_of_Sale;
		}

		cout << "Enter Sale Price of Car: " << endl;
		cin >> UsersCar.Sale_Price;
		while (UsersCar.Sale_Price < 0)
		{
			cout << "No Such Thing as Negative Sale Price. " << endl
				 << "Enter Real Sale Price: " << endl;
			cin >> UsersCar.Sale_Price;
		}
		
		CarArray[i] = UsersCar;

	}

	cout << "The Car's Information: " << endl << endl;

	for (int i = 0; i < 3; i++)

		cout	<< "Manufactor:   "	<< CarArray[i].Car_manufacturer << endl
				<< "Model:        "	<< CarArray[i].Model << endl
				<< "Year Of Sale: " << CarArray[i].Year_of_Sale << endl
				<< "Sale Price:   "	<< CarArray[i].Sale_Price << endl << endl;

		system("PAUSE");

		return 0; 

}