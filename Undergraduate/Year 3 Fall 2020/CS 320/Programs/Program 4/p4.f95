! f95 -o p4 p4.f95
PROGRAM P4
	
	IMPLICIT NONE
	
	! Variable declarations
	TYPE city
		CHARACTER(20) :: name
	END TYPE
	CHARACTER(20) :: filename
	INTEGER :: count, ios, i, j, distance, best_distance, permutations
	TYPE(city), ALLOCATABLE, DIMENSION(:) :: city_list
	INTEGER, ALLOCATABLE, DIMENSION(:) :: path, best_path
	INTEGER, ALLOCATABLE, DIMENSION(:,:) :: d_table
	
	
	! Output Student Data
	PRINT *,
	PRINT *, "Program #4, cssc2629, Stephen Giang"
	PRINT *,
	
	!Open the file and read number of cities
	PRINT *, "Enter filename: "
	READ *, filename
	PRINT *,
	
	OPEN( unit = 1, file = filename, status = 'old', IOSTAT = ios ) 
	IF (ios /= 0) THEN
		PRINT *, "Could Not Open File ", TRIM(filename)
		PRINT *, "Error Code: ", ios
		STOP
	END IF
	READ(1, *), count
	
	
	!Allocate memory for all needed arrays
	ALLOCATE(city_list(count), d_table(count, count), path(count), best_path(count),  STAT = ios)
	IF (ios /= 0) THEN
		PRINT *, "Error: Could NOT Allocate Memory"
	END IF
	
	
	!Fill in arrays from data file
	DO i = 1, count	
		READ(1, FMT = 200), city_list(i)%name 
		DO j = 1, count
			READ(1, *), d_table(j,i)
		END DO
	END DO
	
	CLOSE( unit = 1, status = 'keep' )
	
	DO i = 1, count
		path(i) = i
		best_path(i) = i
	END DO
	
	distance = 0
	best_distance = huge(i)
	permutations = 0
	
	
	!Use recursion to find minimal distance
	call permute(2,count)
	
	
	!Print formatted output
	DO i = 1, (count - 1)
		PRINT 100, TRIM(city_list(best_path(i))%name), " to ", TRIM(city_list(best_path(i+1))%name), &
		" -- ", d_table( best_path(i), best_path(i+1) ), " miles"
	END DO
	PRINT 100, TRIM(city_list(best_path(i))%name), " to ", TRIM(city_list(best_path(1))%name), &
	" -- ", d_table(best_path(i), best_path(1)), " miles"
	PRINT *,
	PRINT 101, "Best Distance: ", best_distance, " miles"
	PRINT *,
	
	
	!Format labels
	100 FORMAT (4a,i6,a)
	101 FORMAT (a,i6,a)
	200 FORMAT (A)
	
	CONTAINS
	
	!Permute function
	RECURSIVE SUBROUTINE permute(first, last)
	
	! Declare intent of parameter variables
	INTEGER :: i, temp, first, last
			IF(first == last)  THEN
				distance = d_table(1,path(2))
				DO i=2, last-1           
					distance = distance + d_table(path(i),path(i+1)) 
				END DO
				distance = distance + d_table(path(last),path(1))
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
 