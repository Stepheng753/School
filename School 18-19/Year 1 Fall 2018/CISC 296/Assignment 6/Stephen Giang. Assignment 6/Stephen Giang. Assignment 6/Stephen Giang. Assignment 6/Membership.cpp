//Membership Program
#include <iostream> 
#include <string> 

using namespace std;

int main()
{

	int MonthlyPurchaseBasic; // Monthly Purchase Basic
	int MonthlyPurchaseStandard; // Monthly Purchase Standard
	int MonthlyPurchasePremium; // Monthly Purchase Premium
	double n;   // Total Purchases
	string input; // Input

	cout << "For Basic, Type 'B'\nFor Standard, Type 'S'\nFor Premium, Type 'P'\n";
	cout << "Enter Membership Type: ";
	getline(cin, input);
	
	//Basic
	if ( input[0] == 'B' || input[0] == 'b')
	{
		cout << "\nEnter Total Purchases for this Month: ";
		cin >> n;
		if (n >= 0 && n <= 100 )
			MonthlyPurchaseBasic = .1 * n;
		else if (n >= 101)
			MonthlyPurchaseBasic = .15 * n;
		cout << "\nReward Points for Basic: " << MonthlyPurchaseBasic << "\n";
	}
	
	// Standard
	else if (input[0] == 'S' || input[0] == 's')
	{
		cout << "\nEnter Total Purchases for this Month: ";
		cin >> n;
		if (n >= 0 && n <= 100)
			MonthlyPurchaseStandard = .15 * n;
		else if (n >= 101)
			MonthlyPurchaseStandard = .20 * n;
		cout << "\nReward Points for Standard: " << MonthlyPurchaseStandard << "\n";
	}

	//Premium
	else if (input[0] == 'P' || input[0] == 'p')
	{
		cout << "\nEnter Total Purchases for this Month: ";
		cin >> n;
		if (n >= 0 && n <= 100)
			MonthlyPurchasePremium = .20 * n;
		else if (n >= 101)
			MonthlyPurchasePremium = .30 * n;
		cout << "\nReward Points for Premium: " << MonthlyPurchasePremium << "\n";
	}

	system("pause");
	return 0;

}