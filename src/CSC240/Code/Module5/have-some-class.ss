(let (( letters '(A B C S T U) ))
   (cons
      (cons 
         (car (cdr (cdr letters)))
         (cons
            (car (cdr (cdr (cdr letters)))) 
            (car (cdr (cdr letters)))
          )
       )
       (* 2 2 2 2 3 5)
   )
)