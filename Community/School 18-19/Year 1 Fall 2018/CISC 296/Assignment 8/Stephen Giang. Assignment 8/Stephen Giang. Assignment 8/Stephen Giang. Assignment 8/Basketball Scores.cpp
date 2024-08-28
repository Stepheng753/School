#include<iostream>

using namespace std;

	///////////////////////////////////////////////////////////////////////////

// Sort Function

void sort(int x[], int Size)

{
	int i, j;

	for (i = 0; i < Size - 1; i++)

	{

		for (j = 0; j < Size - i - 1; j++)

		{

			if (x[j] > x[j + 1])

			{

				int entry = x[j];

				x[j] = x[j + 1];

				x[j + 1] = entry;

			}

		}

	}

}

	///////////////////////////////////////////////////////////////////////////

// How to Calculate the Average

double average(int Scores[], int Size)

{
	int i,
		Sum = 0;

	// Sum

	for (i = 0; i < Size; i++)

		Sum += Scores[i];

	// Average

	return (double) Sum / Size;

}
	///////////////////////////////////////////////////////////////////////////
int main()

{
	///////////////////////////////////////////////////////////////////////////
	
	// Enter Number of Scores

	int n;

	cout << "Enter number of scores : ";

	cin >> n;

	///////////////////////////////////////////////////////////////////////////

	// create array of size n

	int Scores = new int[n];

	cout << "Enter " << n << " scores : \n(SEPERATE BY PRESSING 'ENTER')\n\n";

	///////////////////////////////////////////////////////////////////////////
	
	// get scores from user

	int i;

	for (i = 0; i < n; i++)

		cin >> Scores[i];

	///////////////////////////////////////////////////////////////////////////

	// Sort Scores

	sort(Scores, n);

		cout << "\nSorted Scores from Least to Greatest : \n\n";

		for (i = 0; i < n; i++)

			cout << Scores[i] << endl;
			
			cout << endl;

	///////////////////////////////////////////////////////////////////////////

	// Get Average

	double Average = average(Scores, n);

	cout << "The Average of the Scores is : " << Average << endl << endl;

	///////////////////////////////////////////////////////////////////////////

	system("PAUSE");

	return 0;

	///////////////////////////////////////////////////////////////////////////

	//FIN

}