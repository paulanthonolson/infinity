(define foo (lambda  (x) (+ (* x x ) x))) ; foo(x) = x2 + x
(map foo '(3 6 9 12 15 18))

(define first-char (lambda (S) (string-ref S 0)))

(map (lambda (S) (string-ref S 0)) '("This" "is" "a" "test" "of" "my" "map"))

(define onescomplement (lambda (L)
   (if (null? L)
      '()
      (if (= (car L) 0)
         (cons 1 (onescomplement (cdr L)))
         (cons 0 (onescomplement (cdr L)))
      )
   )
)) 

(define not-gate (lambda(x) (if (= x 0) 1 0)))
(define onescomplement (lambda (L)
	(map not-gate L)))


(define ones-complement (lambda (L)
	(map (lambda(x) (if (= x 0) 1 0)) L)))
	
(define sum-list (lambda (x)
	(if (null? x)
	   0
	   (+ (car x) (sum-list (cdr x)))
	)
))

(define reduce (lambda (op base L)
      (if (null? L)
         base
         (op (car L) (reduce op base (cdr L)))
	   )
))

(define average (lambda (L) 
   (/ (reduce +  0  L) 
      (length L)
   )
))

(define filter (lambda (pred L)
   (if (null? L)
      '()
      (if (pred (car L))
         (cons (car L) (filter pred (cdr L)))
         (filter pred (cdr L))
	   )
	)
))






