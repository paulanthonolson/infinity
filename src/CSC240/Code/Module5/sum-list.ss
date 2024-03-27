(define sum-list (lambda (x)
	(if (null? x)
	   0
	   (+ (car x) (sum-list (cdr x)))
	)
))