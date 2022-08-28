/*
   *  Program 1 - p1b.c
   *  This C program calculates the months and total interest precisely the same as program p1a.c, 
   *  It just gets the input from the command line instead of the user.
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
   * This procedure accepts as parameters first argv, then the addresses of loanAmt, intRate,
   * and payment (in that order), extracts these values from the array of strings (argv) without prompting the
   * user for input. It returns void
*/
void getLoanFactors(char** ,double*, double*, double*);


/*
   * The function returns an int which is the number of months to pay off the loan.
*/
int getMonths(double, double, double, double*);


/*
   * This function has four input parameters from the command line which are passed in as argv.
   * argv[0] is the name of the program (â€œp1bâ€), followed by loanAmt (argv[1]), intRate (argv[2]), and payment
   * (argv[2]), in that order. It then calls printId(), getLoanFactors(), getMonths(), then prints the results. It
   * terminates by returning an int value: 0, unless the user does not provide four arguments on the command
   * line, in which case it prints a message:
   * Usage: p1b dblLoanAmt dblIntRate dblMoPayment
   * then exits the program, returning an int value of 255.
*/
int main(int argc, char** argv) {

    if (argc != 4) {
        printf("Usage: p1b dblLoanAmt dblIntRate dblMoPayment\n");
        return 255;
    }

    double loanAmt;
    double intRate;
    double payment;
    double totalInt = 0;

    printId();
    getLoanFactors(argv ,&loanAmt, &intRate, &payment);
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

void getLoanFactors(char** argv,double* loanAmt, double* intRate, double* payment) {

    *loanAmt = atof(argv[1]);
    *intRate = atof(argv[2]);
    *payment = atof(argv[3]);

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