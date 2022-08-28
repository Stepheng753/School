# Header comment section (typical assignment info)
import sys


# This function begins execution of program.
# Verify data input filename provided on command line: len(sys.argv)
# If error, output message for user: Usage: p3.py dataFileName'
# and quit, using sys.exit()
#
# Declare A, B, call read_matrices to initialize A, B, and store
# return value as C
#
# Print A and B contents
#
# Call mult_matrices
#
# Print result contents
#
def main():
    print("Program #3, cssc2629, Stephen Giang")

    if len(sys.argv) != 2:
        print("Usage: p3.py dataFileName")
        sys.exit()

    A = []
    B = []
    C = read_matrices(A, B)
    print("Matrix A contents: ")
    print_matrix(A)
    print("\nMatrix B contents: ")
    print_matrix(B)
    mult_matrices(A, B, C)
    print("\nMatrix A * B is: ")
    print_matrix(C)


# This function reads m, n, and p from the datafile.
# Then matrices A and B are filled from the datafile.
# Matrix C is then allocated size m x p.
# The values for m, n, and p are local values filled in by this function
# PARAMETERS in order are:
# list matrix A
# list matrix B
# RETURN matrix C
def read_matrices(A, B):
    try:
        my_list = []
        num_lines = 0
        with open(sys.argv[1]) as f:
            for line in f:
                num_lines += 1

        with open(sys.argv[1]) as f:
            for i in range(8):
                my_list.append([int(x) for x in next(f).split()])

        m = my_list[0][0]
        n = my_list[1][0]
        p = my_list[2][0]

        for row in range(m):
            A.append(my_list[3 + row])

        for row in range(n):
            B.append(my_list[3 + m + row])

        C = []
        for row in range(m):
            C.append([0 for x in range(p)])

        return C

    except FileNotFoundError:
        print("No Such File Name or Directory: %s" % sys.argv[1])
        sys.exit()



# This function prints a matrix. Rows and columns should be preserved.
# PARAMETERS in order are:
# list
# The matrix to print
def print_matrix(matrix):
    num_rows = len(matrix)
    num_cols = len(matrix[0])

    for i in range(0, num_rows):
        for j in range(0, num_cols):
            print("%5d" % matrix[i][j], end=" ")
        print()


# The two matrices A and B are multiplied, and matrix C contains the
# result.
# PARAMETERS in order are:
# list Matrix A
# list Matrix B
# list Matrix C (all zeros at this point)
def mult_matrices(A, B, C):
    # A - m x n
    # B - n x p
    # C - m x p
    m = len(A)
    n = len(A[0])
    p = len(B[0])

    for i in range(0, m):
        for j in range(0, p):
            c = 0
            for k in range(0, n):
                c += A[i][k] * B[k][j]
            C[i][j] = c


if __name__ == '__main__':
    main()
