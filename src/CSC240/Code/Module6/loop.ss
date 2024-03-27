(define prt (lambda (x) (begin (display x) (newline))))
(define next (lambda (x) (+ x 1)))
(define lt5? (lambda (x) (< x 5)))

(define loop (lambda (start_expr cont_cond inc_expr body)
   (if (cont_cond start_expr)
      (begin
	(body start_expr)
	(loop (inc_expr start_expr) cont_cond inc_expr body)
      )
      '()
   )
))

(loop 1 lt5? next prt)
