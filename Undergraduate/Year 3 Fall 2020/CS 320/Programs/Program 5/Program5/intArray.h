// intArray.h
// Provided by instructor, CS320 Fall 2018

#ifndef _INTARRAY_H
#define _INTARRAY_H
#include <iostream>
#include <iomanip>
#include "string.h"         // warnings issued whether this or <string>
#include <fstream>          // necessary for external file ptr
#include <stdlib.h>

using std::ostream;

class intArray {
private:
    const char* name;       // array's name
    int* pA;                // dynamic array
    int size;               // size of array
    int hi;                 // largest index
    int lo;                 // smallest index
public:
    // Overloaded ctors
    intArray();                         // IntArray z
    intArray(int);                     // IntArray y(size)
    intArray(int, int);                 // IntArray x(lowerIndex,upperIndex)
    intArray(const intArray&);          // IntArray w(anotherIntArray)
    ~intArray();                        // Destructor

    // Overloaded operators
    int operator==(const intArray&);
    int operator!=(const intArray&);
    int& operator[] (int);
    intArray& operator=(const intArray&);
    intArray operator+(const intArray&);
    intArray& operator+=(const intArray&);
    friend ostream& operator<<(ostream&, const intArray&);

    // Helper functions
    void setName(char* name);
    void getName();
    int  high();
    int  low();
};

#endif