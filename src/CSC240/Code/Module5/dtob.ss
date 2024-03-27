(define dtob (lambda (N) 
   (if (= N 0)
      (list '0)	    
      (append 
	     (dtob (quotient N 2))
         (list (remainder N 2))
      )
   )
)) 
