
# include <iostream>
# include "intArray.h"

using namespace std;

// IntArray z
intArray::intArray() {
	name = "z";
	hi = 9;
	lo = 0;
	size = hi - lo + 1;
	pA = new int[size];
}

// IntArray y(size)
intArray::intArray(int size) {
	name = "y";
	hi = size - 1;
	lo = 0;
	this->size = size;
	if (size < 0) {
		cout << "Halt Expected Because {Run Time Error: Illegal Array Length}\n";
		this->size = 0;
	}
	pA = new int[size];
}

// IntArray x(lowerIndex,upperIndex)
intArray::intArray(int lo, int hi) {
	name = "x";
	this->hi = hi;
	this->lo = lo;
	if (hi >= lo) {
		size = this->hi - this->lo + 1;
	}
	else {
		cout << "Halt Expected Because {RunTime Error: Illegal Array Bounds}\n";
		size = 0;
	}
	pA = new int[size];
}

// IntArray w(anotherIntArray)
intArray::intArray(const intArray& arr2) {
	name = "w";
	this->hi = arr2.hi;
	this->lo = arr2.lo;
	this->size = arr2.size;
	pA = new int[size];
	for (int i = 0; i < size; i++) {
		pA[i] = arr2.pA[i];
	}
}

// Destructor
intArray::~intArray() {
	delete pA;
}

int intArray::operator==(const intArray& arr2) {
	int boolNum = 1;
	if (size == arr2.size) {
		for (int i = 0; i < size; i++) {
			if (pA[i] != arr2.pA[i]) { boolNum = 0; }
		}
	}
	else {
		boolNum = 0;
	}
	return boolNum;
}

int intArray::operator!=(const intArray& arr2) {
	int boolNum = 0;
	if (size == arr2.size) {
		for (int i = 0; i < size; i++) {
			if (pA[i] != arr2.pA[i]) { boolNum = 1; }
		}
	}
	else {
		boolNum = 1;
	}
	return boolNum;
}

int& intArray::operator[](int index) {
	if (index >= lo && index <= hi) {
		return pA[index - lo];
	}
	else {
		cout << "Halt Expected Because {RunTime Error: Illegal Index}\n";
		return pA[0];
	}
}

intArray& intArray::operator=(const intArray& arr2) {
	if (size == arr2.size) {
		for (int i = 0; i < size; i++) {
			pA[i] = arr2.pA[i];
		}
		return *this;
	}
	else {
		cout << "Halt Expected Because {RunTime Error: Lengths Different}\n";
		return *this;
	}
}

intArray intArray::operator+(const intArray& arr2) {
	if (size == arr2.size) {
		intArray arr3(size);
		for (int i = 0; i < size; i++) {
			arr3.pA[i] = pA[i] + arr2.pA[i];
		}
		return arr3;
	}
	else {
		cout << "Halt Expected Because {RunTime Error: Lengths Different}\n";
		return *this;
	}
}

intArray& intArray::operator+=(const intArray& arr2) {
	if (size == arr2.size) {
		for (int i = 0; i < size; i++) {
			pA[i] += arr2.pA[i];
		}
		return *this;
	}
	else {
		cout << "Halt Expected Because {RunTime Error: Lengths Different}\n";
		return *this;
	}
}

ostream& operator<<(ostream& os, const intArray& arr) {
	for (int i = 0; i < arr.size; i++) {
		os << arr.name << "[" << i + arr.lo << "] = " << arr.pA[i] << endl;
	}
	return os;
}


void intArray::setName(char* name) {
	this->name = name;
}

void intArray::getName() {
	cout << name;
}

int intArray::high() {
	return hi;
}

int intArray::low() {
	return lo;
}
