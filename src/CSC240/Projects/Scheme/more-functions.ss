(newline)
(display "Scheme Functions - Paul Olson") (newline)
(newline)

(define volume
 (lambda (shape d)
  (case shape
    ((sphere) (* (/ 4 3) 3.14159 (* d d d)))
    ((cube) (* d d d))
    (else 0))))

(display "Volume") (newline)
(display (volume 'unknown 5)) (newline)
(display (volume 'cube 5)) (newline)
(display (volume 'sphere 5)) (newline)

#| (define my-sqrt 
(lambda (n)
( / 2 (+ r(/ n r))
))) |#

#|
(newline)
(display "My Square Root") (newline)
(display (my-sqrt 9)) (newline)
(display (my-sqrt 100)) (newline)
(display (my-sqrt 2)) (newline)
(display (my-sqrt 12345.678)) (newline)
(display (my-sqrt 100000)) (newline)
|#

(define (zip L1 L2)
(map list L1 L2))

(newline)
(display "Zip Lists") (newline)
(display (zip '() '())) (newline)
(display (zip '(1 3 5 7) '(2 4 6 8))) (newline)
(display (zip '("Washington" "Adams" "Jefferson" "Madison" "Monroe") '("4/30/1789" "3/4/1797" "3/4/1801" "3/4/1809" "3/4/1817"))) (newline)
(display (zip '("Shall" "compare" "to" "summer’s" "Thou" "more" "and" "temperate:")
              '("I" "thee" "a" "day?" "art" "lovely" "more" "-Bill"))) (newline)

(define merge
  (lambda (L1 L2)
    (cond
      ((null? L1) L2)
      ((null? L2) L1)
      (else
       (let ((l1 (car L1))
             (l2 (car L2)))
         (if (<= l1 l2)
             (cons l1 (merge (cdr L1) L2))
             (cons l2 (merge L1 (cdr L2)))))))))

(newline)
(display "Merge Lists") (newline)
(display (merge '() '())) (newline)
(display (merge '(5) '())) (newline)
(display (merge '() '(5))) (newline)
(display (merge '(1 2 3 6 7 8 10) '(4 5 9 11))) (newline)
(display (merge '(6 8) '(1 4 5 9 11))) (newline)

(newline)
(display "Scheme Functions - Done") (newline)
