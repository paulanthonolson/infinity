(define pi-term (lambda (i) 
   (/ (expt -1 i) (+ (* 2 i) 1))
))

(define pi-sum (lambda (i) 
   (if (= i 0) (pi-term 0) (+ (pi-term i) (pi-sum (- i 1))))
))

(define pi-fract (lambda (limit) 
   (* 4 (pi-sum limit))
))

(define pi (lambda (limit) 
   (exact->inexact (* 4 (pi-sum limit)))
))
