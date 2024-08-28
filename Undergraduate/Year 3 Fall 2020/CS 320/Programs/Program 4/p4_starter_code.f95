!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
! PROGRAM P4
!             Traveling Salesman Problem in FORTRAN 95
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
PROGRAM P4

IMPLICIT NONE

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
! Variable declarations


!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!Open the file and read number of cities


!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!Allocate memory for all needed arrays

  

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!Fill in arrays from data file

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!Use recursion to find minimal distance
call permute(2,count)

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!Print formatted output

                
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!Format labels
100 FORMAT (I6)
200 FORMAT (A)


CONTAINS
!Permute function
RECURSIVE SUBROUTINE permute(first, last)
! Declare intent of parameter variables

INTEGER :: i, temp
        IF(first == last)  THEN
            distance = d_table(1,path(2))
            PRINT *, city_list(1)%name, city_list(path(2))%name, " ", d_table(1, path(2))
            DO i=2, last-1           
                distance = distance + d_table(path(i),path(i+1)) 
                print *, city_list(path(i))%name, " ", city_list(path(i+1))%name,&
                d_table(path(i),path(i+1)) 
            END DO
            distance = distance + d_table(path(last),path(1))
            PRINT *, city_list(path(last))%name," ",city_list(path(1))%name, &
                d_table(path(last),path(1))
            PRINT *, "Distance is ",distance
            PRINT *
            permutations = permutations + 1
            IF(distance < best_distance) THEN
                best_distance = distance
                DO i=2, count
                    best_path(i) = path(i)
                END DO
            END IF
            
        ELSE
            DO i=first, last
                temp = path(first)
                path(first) = path(i)
                path(i) = temp

                call permute(first+1,last)
         
                temp = path(first)
                path(first) = path(i)
                path(i) = temp
            END DO
        END IF
END SUBROUTINE permute 

END PROGRAM P4
