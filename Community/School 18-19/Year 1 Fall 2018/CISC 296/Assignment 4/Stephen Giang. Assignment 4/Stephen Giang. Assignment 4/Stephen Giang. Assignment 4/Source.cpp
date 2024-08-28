//Fail The Students
#include <iostream> 
#include <string> 

using namespace std;

int main()
{
	string input;
	double grade = 0.0;

	cout << "Enter a letter grade: ";
	getline(cin, input);

	if (input[0] == 'a' || input[0] == 'A')
	{
		grade = 4.0;
	}

	else if (input[0] == 'b' || input[0] == 'B')
	{
		grade = 3.0;
	}
	
	else if (input[0] == 'c' || input[0] == 'C')
	{
		grade = 2.0;
	}

	else if (input[0] == 'd' || input[0] == 'D')
	{
		grade = 1.0;
	}

	else if (input[0] == 'f' || input[0] == 'F')
	{
		grade = 0;
	}

	// add 0.3 to 'grade'
	if (((((input[1] == '+')&& input[0]!=('F'))&& input[0] != ('f')) && input[0] != ('A')) && input[0] != ('a'))
	{
		grade += 0.3;  
	}

	// subtract 0.3 from 'grade'
	else if (((input[1] == '-')&& input[0]!= ('F')) && input[0] != ('f'))
	{
		grade -= 0.3;  
	}

	cout << "The Numeric Value is: " << grade << "\n";

	system("Pause");
	return 0;
}