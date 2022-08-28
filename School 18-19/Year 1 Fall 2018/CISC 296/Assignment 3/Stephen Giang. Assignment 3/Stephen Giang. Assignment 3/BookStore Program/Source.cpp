// Chapter 3 : Assignment 3 : BookStore Problem
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	//Variables
	double BookPrice,
		   Num_Books,
		   Tax,
		   ShippingCharge,
		   Price_BookOrder;

	//Get BookPrice
	cout << "Enter Book Price: ";
	cin >> BookPrice;

	//Get Num_Books
	cout << "Number of Books: ";
	cin >> Num_Books;

		//Get Tax
		Tax = (BookPrice * Num_Books) * .085;

		//Get Shipping Charge
		ShippingCharge = (3 * Num_Books);

        //Get Price_BookOrder
		Price_BookOrder = ((BookPrice * Num_Books) + Tax + ShippingCharge);

	//Display Price_BookOrder
	cout << "\nThe Price of the Book Order is: "
		 << fixed << showpoint << setprecision(2)
		 << Price_BookOrder << endl;
	system("Pause");
	return 0; 
}