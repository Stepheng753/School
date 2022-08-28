  /**
   *  Program 2
   *  Recursively Makes Linked List in C
   *  CS320
   *  10/07/20
   *  @author  Stephen Giang cssc2629
   */


#include "llist.h"


void printId() {

	printf("\nProgram 2, cssc2629, Stephen Giang\n\n");

}


void insertO(Link head) {

	/*	Finds 't' in the string	*/
	Link tVal = find('t', head);
	if (tVal != NULL) {
		/*	Creates Node with 'o'	*/
		Link oVal = (Link)malloc(sizeof(Node));
		oVal->data = 'o';
		oVal->next = NULL;

		/*	Inserts 'o' node after 't'	*/
		insert(tVal, tVal->next, oVal);

		/*	Finds the next 't' recursively	*/
		insertO(oVal);
	}
}

int main(int argc, char const* argv[]) {

	/*	Output student/account info	*/
  	printId();
  

  	/*	Error check command line arguments using perror()	*/
	if (argc != 2) {
		perror("Input file error");
		printf("\n");
    	return(-1);
	}


	/*	Open file (error check) using fopen() */
	FILE *database;
   	database = fopen(argv[1], "r");


   	/*	Read in file content into a char buffer and echo buffer using printf(“> %s\n”, buffer);	*/
   	char buffer[30];
    if (NULL == database) {
    	perror("Error opening file");
        printf("\n");
        return(-1);
    }
    while (EOF != fscanf(database, "%[^\n]\n", buffer)) {
         printf("> %s\n", buffer);
    }
    /*	fclose() file pointer	*/
    fclose(database);


    /*	Create list from buffer using strToList()	*/
	Link head = strToList(buffer);
	/*	print() the newly created list	*/
	print(head);
	/*	Print size()	*/
	printf("%i\n", size(head));


	/*	insert() and ‘o’ after the letter ‘t’ if ‘t’ is in the list. Do nothing otherwise.	*/
	insertO(head);
	/*	print() the list	*/
	print(head);
	/*	Print size()	*/
	printf("%i\n", size(head));


	/*	delete() the third letter in the list you may assume the list has at least three elements)	*/
	Link second = head->next;
  	Link third = second->next;
	delete(second, third);
	print(head);


	/*	deleteList()	*/
	deleteList(head);
 

	/*	For Formatting	*/
	printf("\n");

 	/*	return(0)	*/
  	return(0);


}
