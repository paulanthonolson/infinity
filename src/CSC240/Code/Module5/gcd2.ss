(define gcd2 (lambda (n m)
              (if (= n 0)
                  m
                  (if (<= n m)
                      (gcd2 n (- m n))
                      (gcd2 m n)
))))                           
