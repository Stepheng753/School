  /**
   *  Program 2
   *  Recursively Makes Linked List in C
   *  CS320
   *  10/07/20
   *  @author  Stephen Giang cssc2629
   */


#include "llist.h"


/* strToList
 *    Creates a dynamic list from a string (char[] in C)
 *       Prints current string with each call to strToList
 *    Returns head of new list
 */
Link strToList(char s[]) {

	/*	Makes Empty Node	*/
	Link head = (Link)malloc(sizeof(Node));

	/*	Puts the beginning of array as head.data	*/
	head->data = *s;


	/*	Prints current string with each call to strToList	*/
	int i = 0;
	while (s[i] != '\0') {
		printf("%c", s[i]);
		i = i + 1;
	}
	printf(": %c\n", head->data);


	/*	If next char ends string, then set next to null	*/
	if (*(s+1) == '\0') {
		head->next = NULL;
	}
	/*	Recursive step, but with next index of array	*/
	else {
		char* sptr = s + 1;
		head->next = strToList(sptr);
	}


	/*	Returns head	*/
	return head;

}

/* size
 *    Recursively counts elements in the list
 *    Returns int
 */
int size(Link head) {
	if (head == NULL) {
		return 0;
	}
	return size(head->next) + 1;
}

/* find
 *    Recursively iterates through the list to locate the Data element
 *    Returns NULL if list is empty or it reaches end of list (NULL)
 *    Returns Link a pointer to the Data element if found
 */
Link find(Data c, Link head) {
	if (head == NULL) {
		return NULL;
	}
	else if (head->data == c) {
		return head;
	}
	else {
		return find(c, head->next);
	}
}

/* insert
 *    Adds element q to the list after element p1 and before element p2
 *    Returns void
 *    Assumptions: arguments passed to insert are valid Link elements
 */
void insert(Link p1, Link p2, Link q) {
	p1->next = q;
	q->next = p2;
}

/* delete
 *    Removes element q whose predecessor is element p
 *    Returns void (q contains a pointer to the removed element)
 */
void delete(Link p, Link q) {
	p->next = q->next;
	free(q);
}

/* deleteList
 *    Recursively deletes an element from the list, freeing memory
 *       as each element is removed. Prints the element being deleted.
 *    Returns void
 */
void deleteList(Link head) {
	if (head != NULL) {
		printf("deleting %c\n", head->data);
		Link next = head->next;
		free(head);
		deleteList(next);
	}
}

/* print
 *    Recursively prints the Data elements in the list
 *    Returns void
 */
void print(Link head) {
	printf("%c ", head->data);
	if (head->next != NULL) {
		print(head->next);
	}
	else {
		printf("\n");
	}
}
