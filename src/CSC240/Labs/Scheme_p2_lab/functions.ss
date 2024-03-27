; Define circ-incr here

; Define ++ here

; Define quake here

; Define fib here

; Define occ here




(display "Lambda Expressions - Prof. Eckert") (newline)
(newline)

#|
(display "Circular Increment #1") (newline)
(display (circ-incr 0 5)) (newline)
(display (circ-incr 1 5)) (newline)
(display (circ-incr 2 5)) (newline)
(display (circ-incr 3 5)) (newline)
(display (circ-incr 4 5)) (newline)
|#

#|
(newline)
(display "Circular Increment #2") (newline)
(display (++ 0 5)) (newline)
(display (++ 1 5)) (newline)
(display (++ 2 5)) (newline)
(display (++ 3 5)) (newline)
(display (++ 4 5)) (newline)
|#

#|
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
|#

#|
(newline)
(display "Fibonacci") (newline)
(display (fib 0)) (newline)
(display (fib 1)) (newline)
(display (fib 2)) (newline)
(display (fib 5)) (newline)
(display (fib 10)) (newline)
(display (fib 25)) (newline)
|#

#|
(newline)
(display "Occurences") (newline)
(display (occ 5 '()))          (newline)
(display (occ 5 '(1 2 3 4 6))) (newline)
(display (occ 5 '(1 2 3 4 5))) (newline)
(display (occ 5 '(5 2 5 4 5))) (newline)
(display (occ 5 '(5 5 5 5 5))) (newline)
|#

(newline)
(display "Lambda Expressions - Done") (newline)
