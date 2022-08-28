/**
 * Program: 4
 * Description : Mini Math Programming Language
 * Class: CS 108-2
 *
 * @author Stephen Giang
 * @date 11/10/2019
 **/

// An generic interface called Builder that uses a generic type called E
interface Builder <E>
{
    // Specify a method called build that has an input argument of type String and returns the generic type
    <E> E build(String tokenString);
}
