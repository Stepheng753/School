;
; Program 6
; Recursive Functions of Lists
; CS320
; 12 / 2 / 20
; @author Stephen Giang cssc2629
;

; p6.scm
; A prototype for program 6 in Scheme
;
;
; Edit this file to add your documentation and function definitions.
; Leave the rest of this file unchanged.
;
; To run this file, you would start scheme at edoras command line prompt:
; scheme --load p6.scm, where the file is in the current directory
; and then in scheme type the load command (from the '%' prompt):
;(load "p6.scm")
;
; Defined LISTS for use with testing your functions.
; Defined LISTS for use with testing your functions.
(define list0 (list 'j 'k 'l 'm 'n 'o 'j) )
(define list1 (list 'a 'b 'c 'd 'e 'f 'g) )
(define list2 (list 's 't 'u 'v 'w 'x 'y 'z) )
(define list3 (list 'j 'k 'l 'm 'l 'k 'j) )
(define list4 (list 'n 'o 'p 'q 'q 'p 'o 'n) )
(define list5 '((a b) c (d e d) c (a b)) )
(define list6 '((h i) (j k) l (m n)) ) 
(define list7 '(f (a b) c (d e d) (b a) f) )
;
; Here is a typical function definition from Sebesta Ch. 15
(define (adder lis)
  (cond
      ((null lis) 0)
      	(else (+ (car lis) (adder (cdr lis))))
))
; The above five lines are the sort of definition you would need to add to
; this file if asked to define an ADDER function.
; Uncomment and complete the following four definitions. At least have ODDS
; so the program can be tested.

(define (evens lst)
  (cond
    ((list? lst)
    (cond
      ((or (null? lst) (null? (cdr lst)) ) '() )
      ( else (cons (cadr lst) (evens (cddr lst)) ))
      ))
    (else (display "Usage: (evens {list})\n"))
    )
 )

(define (odds lst)
  (cond
    ((list? lst)
    (cond
      ((null? lst) '() )
      ((null? (cdr lst)) (append (list (car lst)) (odds (cdr lst)) ) )
      (else (append (list (car lst)) (odds (cddr lst)) ))
    ))
    (else (display "Usage: (odds {list})\n"))
    )
 )

(define (oddrev lst)
  (cond
    ((list? lst)
    (cond
      ((null? lst) '() )
      ((null? (cdr lst)) (append (oddrev (cdr lst)) (list (car lst))) )
      (else (append (oddrev (cddr lst)) (list (car lst))  ))
    ))
    (else (display "Usage: (oddrev {list})\n"))
    )
 )

(define (reverseList lst)
  (cond
    ((null? (cdr lst)) (list (car lst)))
    (else (append (reverseList (cdr lst)) (list (car lst))))
    ))

(define (middle lst)
  (cond
    ((list? lst)
    (cond
      ((null? lst) '())
      ((null? (cdr lst)) (list (car lst)))
      ((null? (cddr lst)) '())
      (else (middle (reverseList (cdr (reverseList (cdr lst))))))
    ))
    (else (display "Usage: (middle {list})\n"))
    )
 )

(define (bookends lst)
  (cond
    ((list? lst)
    (cond
      ((or (null? lst) (null? (cdr lst))) #t)
      ((equal? (car lst) (car (reverseList lst))) #t)
      (else #f)
    ))
    (else (display "Usage: (bookends {list})\n"))
    )
 )