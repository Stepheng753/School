// This Program calculates the average of the 
// Stock prices over any number of days

#include <iostream>
#include <iomanip>
using namespace std;

int main() 
{
	int day = 1,	// day Counter
		n;			// Number of days
	double  price,		//To hold the Stock Price
			sum =0,		// Accumulator
			average;	// Calculate Average
		

	cout << "Enter the Stock Price for Each Day\n";
	cout << "Enter -1 when finished.\n\n";
	cout << "Enter number of days : ";
		cin >> n;

	cout << "Enter the Price of Stock on Day " << day << ": ";
		cin >> price;


		while (price != -1)
		{

			sum += price;
			day++;
			cout << "Enter the price of Stock on Day " << day << ": ";
			cin >> price;
		
		}

		average = sum / n;

		if (day == 1 && price == -1)
			cout << "\nNO STOCK WAS ENTERED!\n";

		

		cout << "\nThe Average of the Stock Prices is " 
			<< fixed << showpoint 
			<< setprecision(2) << average << endl;

		system("PAUSE");

		return 0;
} 
