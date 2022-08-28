#include<iostream>
#include<fstream>
#include<string>
#include<iomanip>
#include<iostream>
using namespace std;

void displayArray(int points[], int numElements);
double getAverage(int points[], int numElements);

int main()
{
	int numElements,
		day1,
		day2,
		day3,
		day4,
		day5;

	numElements = 5;

	cout << "ONLY ENTER WHOLE NUMBER SCORES" << endl;
	cout << "Enter Score for Day 1: ";
	cin >> day1;
	cout << "Enter Score for Day 2: ";
	cin >> day2;
	cout << "Enter Score for Day 3: ";
	cin >> day3;
	cout << "Enter Score for Day 4: ";
	cin >> day4;
	cout << "Enter Score for Day 5: ";
	cin >> day5;

	int points[5];
	points[0] = day1;
	points[1] = day2;
	points[2] = day3;
	points[3] = day4;
	points[4] = day5;

	displayArray(points, numElements);
	getAverage(points, numElements);

	return 0;
}


void displayArray(int points[], int numElements)

{
	cout << "Score for Day 1: " << points[0] << endl;
	cout << "Score for Day 2: " << points[1] << endl;
	cout << "Score for Day 3: " << points[2] << endl;
	cout << "Score for Day 4: " << points[3] << endl;
	cout << "Score for Day 5: " << points[4] << endl;

}

double getAverage(int points[], int numElements)
{
	cout << "The Average is: (" 
		<< points[0] << "+" << points[1] << "+" << points[2] << "+" << points[3] << "+" << points[4] << ") / " << numElements 
		<< " = " 
		<< (points[0] + points[1] + points[2] + points[3] + points[4]) / (double)numElements << endl;
	system("PAUSE");

	return 0;
}

