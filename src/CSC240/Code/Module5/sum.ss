(define sum (lambda (L)
   (if (null? L)
      0
     (+ (car L) (sum (cdr L)))
   )
))
