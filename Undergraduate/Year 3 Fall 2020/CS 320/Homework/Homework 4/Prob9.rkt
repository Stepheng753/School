#lang scheme

(define (tally atm list)
 (cond
 ( (null? list) 0 )
 ( (eq? atm (car list)) (+ 1 (tally atm (cdr list))) )
 ( else (tally atm (cdr list)))
))

(tally 0 '(4 0 3 0 2 0 1))