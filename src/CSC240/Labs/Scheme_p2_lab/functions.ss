; Define circ-incr here

(define circ-incr (lambda (value size) 
(remainder (+ value 1) size)
))

; Define ++ here

(define ++ (lambda (value size)
(remainder (+ value 1) size)
))

; Define quake here

(define quake (lambda (value)
(cond
    ( (>= value 8.0) "Great")
    ( (>= value 7.0) "Major")
    ( (>= value 6.0) "Strong")
    ( (>= value 5.0) "Moderate")
    ( (>= value 4.0) "Light")
    ( (>= value 2.0) "Minor")
    ( else           "Micro")
    )
))

; Define fib here

(define fib (lambda (value)
(if (<= value 1)
value
    (+ (fib (- value 1))
    (fib (- value 2))))))
; Define occ here

(define occ (lambda (value list)
(cond 
    ( (null? list) 0 )
    ( (= (car list) value) (+ 1 (occ value (cdr list) )))
    ( else                 (+ 0 (occ value (cdr list) )))
)
))




(display "Lambda Expressions - Paul Olson") (newline)
(newline)


(display "Circular Increment #1") (newline)
(display (circ-incr 0 5)) (newline)
(display (circ-incr 1 5)) (newline)
(display (circ-incr 2 5)) (newline)
(display (circ-incr 3 5)) (newline)
(display (circ-incr 4 5)) (newline)



(newline)
(display "Circular Increment #2") (newline)
(display (++ 0 5)) (newline)
(display (++ 1 5)) (newline)
(display (++ 2 5)) (newline)
(display (++ 3 5)) (newline)
(display (++ 4 5)) (newline)



(newline)
(display "Quake") (newline)
(display (quake 0.0)) (newline)
(display (quake 1.9)) (newline)
(display (quake 3.0)) (newline)
(display (quake 4.5)) (newline)
(display (quake 5.0)) (newline)
(display (quake 6.2)) (newline)
(display (quake 7.9)) (newline)
(display (quake 8.5)) (newline)



(newline)
(display "Fibonacci") (newline)
(display (fib 0)) (newline)
(display (fib 1)) (newline)
(display (fib 2)) (newline)
(display (fib 5)) (newline)
(display (fib 10)) (newline)
(display (fib 25)) (newline)



(newline)
(display "Occurences") (newline)
(display (occ 5 '()))          (newline)
(display (occ 5 '(1 2 3 4 6))) (newline)
(display (occ 5 '(1 2 3 4 5))) (newline)
(display (occ 5 '(5 2 5 4 5))) (newline)
(display (occ 5 '(5 5 5 5 5))) (newline)


(newline)
(display "Lambda Expressions - Done") (newline)
