(display "Scheme Functions - Prof. Eckert") (newline)

#|
(display "Volume") (newline)
(display (volume 'unknown 5)) (newline)
(display (volume 'cube 5)) (newline)
(display (volume 'sphere 5)) (newline)
|#

#|
(newline)
(display "My Square Root") (newline)
(display (my-sqrt 9)) (newline)
(display (my-sqrt 100)) (newline)
(display (my-sqrt 2)) (newline)
(display (my-sqrt 12345.678)) (newline)
(display (my-sqrt 100000)) (newline)
|#

#|
(newline)
(display "Zip Lists") (newline)
(display (zip '() '())) (newline)
(display (zip '(1 3 5 7) '(2 4 6 8))) (newline)
(display (zip '("Washington" "Adams" "Jefferson" "Madison" "Monroe") '("4/30/1789" "3/4/1797" "3/4/1801" "3/4/1809" "3/4/1817"))) (newline)
(display (zip '("Shall" "compare" "to" "summer’s" "Thou" "more" "and" "temperate:")
              '("I" "thee" "a" "day?" "art" "lovely" "more" "-Bill"))) (newline)
|#

#|
(newline)
(display "Merge Lists") (newline)
(display (merge '() '())) (newline)
(display (merge '(5) '())) (newline)
(display (merge '() '(5))) (newline)
(display (merge '(1 2 3 6 7 8 10) '(4 5 9 11))) (newline)
(display (merge '(6 8) '(1 4 5 9 11))) (newline)
|#

(newline)
(display "Scheme Functions - Done") (newline)
