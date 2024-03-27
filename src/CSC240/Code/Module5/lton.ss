(define lton (lambda (lst) 
   (if (null? lst)
      "END"
	  (begin 
	     (write (car lst))
		 (lton (cdr lst))
	  )
    )
))