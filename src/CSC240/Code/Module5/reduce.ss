(define reduce (lambda (op base L)
      (if (null? L)
         base
         (op (car L) (reduce op base (cdr L)))
	   )
))