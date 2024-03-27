(define average
   (lambda ()		; no parameter
      (accumulator 0 0 (read))
   ))
(define compute-average
   (lambda (sum n)
      (if (> n 0) (/ sum n) 
         "no number")
   ))
(define accumulator	; recursive
   (lambda (sum n next)
      (if (not (number? next))	; use of a sentinel
         (compute-average sum n)
         (accumulator (+ next sum) (+ 1 n) (read))
      )))
