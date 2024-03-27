(define not-gate (lambda(x) (if (= x 0) 1 0)))
(define ones-complement (lambda (L)
	(map not-gate L)))

