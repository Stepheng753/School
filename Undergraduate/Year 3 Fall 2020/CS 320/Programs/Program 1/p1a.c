/*
   *  Program 1 - p1a.c
   *  Write a C program that will tell you how many months it will take you to pay off a loan, as well as the total
   *  amount of interest paid over the life of the loan. Your program must read in from stdin the amount of the
   *  loan, the interest rate, and the amount of your monthly payment.
   *  CS320
   *  September 9, 2020
   *  @author  Stephen Giang cssc2629
*/

#include <stdio.h>
#include <stdlib.h>


/*
   * Prints a single line, consisting of
   * The assignment number, your class account, and your name, all on one line
*/
void printId();


/*
   * Reads in these values from the user in the same order. It does not prompt the user to enter values.
   * Its return value is void. Use scanf to read into a double: scanf(â€³%lfâ€³, addrOfMyDoubleVar);
*/
void getLoanFactors(double*, double*, double*);


/*
   * The function returns an int which is the number of months to pay off the loan.
*/
int getMonths(double, double, double, double*);


/*
   * Calls printId(), getLoanFactors(), getMonths(), then prints the results.
   * It terminates by returning an int value: 0.
   * When calling getLoanFactors(), you will need to pass the variables declared in main by address
   * (that is, pass by reference to a memory address).
   * The calling functionâ€™s argument is preceded by an ampersand: callingPassByReference(&myDoubleVar);
*/
int main() {

    double loanAmt;
    double intRate;
    double payment;
    double totalInt = 0;

    printId();
    getLoanFactors(&loanAmt, &intRate, &payment);
    int totalMonths = getMonths(loanAmt, intRate, payment, &totalInt);

    printf("$%7.2lf Loan amount\n", loanAmt);
    printf("%8.2lf Annual interest rate\n", intRate);
    printf("$%7.2lf Monthly Payment\n\n", payment);

    printf(" LoanAmt  Month TotalInt\n");
    int monthCounter = 0;
    double interest = 0;
    double monthlyIntRate = intRate / 12;
    while (loanAmt > 0) {
        interest = loanAmt * monthlyIntRate;
        loanAmt = loanAmt + interest - payment;
        totalInt = totalInt + interest;
        monthCounter = monthCounter + 1;
        printf(" %7.2lf ", loanAmt);
        printf(" %5d ", monthCounter);
        printf("%8.2lf\n", totalInt);
    }
    printf("\n%d months to pay off loan\n", totalMonths);
    printf("$%.2lf total interest paid\n\n", totalInt);

    return 0;
}

void printId() {
    printf("\nProgram 1a, cssc2629, Stephen Giang\n\n");
}

void getLoanFactors(double* loanAmt, double* intRate, double* payment) {

    scanf("%lf", loanAmt);
    scanf("%lf", intRate);
    scanf("%lf", payment);

}

int getMonths(double loanAmt, double intRate, double payment, double* totalInt) {
    
    int totalMonths = 0;
    double interest = 0;
    double monthlyIntRate = intRate / 12;
    while (loanAmt > 0) {
        interest = loanAmt * monthlyIntRate;
        loanAmt = loanAmt + interest - payment;
        totalMonths = totalMonths + 1;
    }

    return totalMonths;
}