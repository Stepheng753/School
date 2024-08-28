#include <iostream>
#include <string>
using namespace std;

class PersonalData
{
	public:

		string name;
		string address;
		int age;
		long long int PhoneNumber;

		void holdname (string nameParameter)
		{
			name = nameParameter;
		}
		string getName()
		{
			return name;
		}

		void holdAddress (string addressParameter)
		{
			address = addressParameter;
		}
		string getAddress()
		{
			return address;
		}

		void holdAge(int ageParameter)
		{
			age = ageParameter;
		}
		int getAge()
		{
			return age;
		}

		void holdPhoneNumber(long long int PhoneNumberParameter)
		{
			PhoneNumber = PhoneNumberParameter;
		}
		int getPhoneNumber()
		{
			return PhoneNumber;
		}

		void storeInfo()
		{
			cout << "Enter Name: ";
			cin >> name;
			cout << "Enter Address: ";
			cin >> address;
			cout << "Enter Age: ";
			cin >> age;
			cout << "Enter Phone Number: ";
			cin >> PhoneNumber;
		}

		void displayInfo()
		{
			cout << "Name: " << name << endl;
			cout << "Address: " << address << endl;
			cout << "Age: " << age << endl;
			cout << "Phone Number: " << PhoneNumber << endl;
		}
};

int main()
{
	PersonalData FirstPerson,
				 SecondPerson,
				 ThirdPerson;


	cout << "Enter 1st Info: " << endl;
	FirstPerson.storeInfo();

	cout << "\nEnter 2nd Person's Info: " << endl;
	SecondPerson.storeInfo();

	cout << "\nEnter 3rd Person's Info: " << endl;
	ThirdPerson.storeInfo();


	cout << "\nPerson #1: " << endl;
	FirstPerson.displayInfo();

	cout << "\nPerson #2: " << endl;
	SecondPerson.displayInfo();

	cout << "\nPerson #3: " << endl;
	ThirdPerson.displayInfo();

	system("PAUSE");

	return 0;
}