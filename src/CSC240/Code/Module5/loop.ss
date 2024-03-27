(define prt (lambda (x) (begin (display x) (newline))))

(define loop (lambda (start finish f)
   (if (= start finish)
      (f finish)
      (begin
	(f start)
	(loop (+ start 1) finish f)
      )
   )
))
