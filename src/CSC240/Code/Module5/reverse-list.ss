(define reverse-list (lambda (lst)
   (if (null? lst)
      '()
      (append (reverse-list (cdr lst)) (list (car lst)))
   )
))
