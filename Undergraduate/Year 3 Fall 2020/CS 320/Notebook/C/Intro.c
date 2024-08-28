// Standard IO Library
#include <stdio.h>

void getNum(int *num) {
	printf("In getNum, enter num: ");
	scanf("%d", num);
}

int main() {
	
	int num;
  printf("Enter Num: ");
	scanf("%d", &num);
	printf("Num is: %d\n", num);
	
	getNum(&num);
	printf("New num: %d\n", num);
	
	return 0;
}