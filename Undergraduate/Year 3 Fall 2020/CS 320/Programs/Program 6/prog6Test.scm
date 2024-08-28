;
; Program 6
; Recursive Functions of Lists
; CS320
; 12 / 2 / 20
; @author Stephen Giang cssc2629
;

#lang scheme

(define list0 (list 'j 'k 'l 'm 'n 'o 'j) )
(define list1 (list 'a 'b 'c 'd 'e 'f 'g) )
(define list2 (list 's 't 'u 'v 'w 'x 'y 'z) )
(define list3 (list 'j 'k 'l 'm 'l 'k 'j) )
(define list4 (list 'n 'o 'p 'q 'q 'p 'o 'n) )
(define list5 '((a b) c (d e d) c (a b)) )
(define list6 '((h i) (j k) l (m n)) ) 
(define list7 '(f (a b) c (d e d) (b a) f) )
(define list8 'a)
(define list9 1)
(define list10 '())


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

(evens list0)
(evens list1)
(evens list2)
(evens list3)
(evens list4)
(evens list5)
(evens list6)
(evens list7)
(evens list8)
(evens list9)
(evens list10)

(display "\n\n")

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

(odds list0)
(odds list1)
(odds list2)
(odds list3)
(odds list4)
(odds list5)
(odds list6)
(odds list7)
(odds list8)
(odds list9)
(odds list10)

(display "\n\n")

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

(oddrev list0)
(oddrev list1)
(oddrev list2)
(oddrev list3)
(oddrev list4)
(oddrev list5)
(oddrev list6)
(oddrev list7)
(oddrev list8)
(oddrev list9)
(oddrev list10)

(display "\n\n")

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

(middle list0)
(middle list1)
(middle list2)
(middle list3)
(middle list4)
(middle list5)
(middle list6)
(middle list7)
(middle list8)
(middle list9)
(middle list10)

(display "\n\n")


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

(bookends list0)
(bookends list1)
(bookends list2)
(bookends list3)
(bookends list4)
(bookends list5)
(bookends list6)
(bookends list7)
(bookends list8)
(bookends list9)
(bookends list10)

(display "\n\n")

