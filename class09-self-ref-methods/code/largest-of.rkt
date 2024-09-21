;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname largest-of) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))


;; largest-of : (NEListof Number) -> Number
;; determines the largest number in a (non-empty) list of numbers
(check-expect (largest-of   (list 23 -2 4 10 52 -10 3)) 52)
(check-expect (largest-of (list 5 23 -2 4 10 52 -10 3)) 52)
(check-expect (largest-of (list 3)) 3)
(check-error  (largest-of empty) "The list is empty!")

(define (largest-of a-lon)
  (cond [(empty? a-lon) (error "The list is empty!")]
        [(cons? a-lon)  (largest-of/acc (rest a-lon) (first a-lon))]))

#; ; original = non-accumulator-style version
(define (largest-of l)
  (cond [(empty? l)        (error "The list is empty!")]
        [(empty? (rest l)) (first l)]
        [(cons? l) (if (> (first l) (largest-of (rest l))) 
                       (first l)
                       (largest-of (rest l)))]))




;; largest-of/acc : [Listof Number] Number -> Number
(check-expect (largest-of/acc (list 23 -2 4 10 52 -10 3) 40)
              52)
(check-expect (largest-of/acc (list    -2 4 10 52 -10 3) 40)
              52)
(check-expect (largest-of/acc (list 52 -10 3) 40)
              52)
(check-expect (largest-of/acc (list    -10 3) 52)
              52)

(check-expect (largest-of/acc (list 23 -2 4 10 52 -10 3) 140)
              140)
(check-expect (largest-of/acc empty 3)
              3)

(define (largest-of/acc a-lon largest-so-far)
  (cond [(empty? a-lon) largest-so-far]
        [(cons? a-lon)  (if (> largest-so-far (first a-lon))
                            (largest-of/acc (rest a-lon) largest-so-far)
                            (largest-of/acc (rest a-lon) (first a-lon)))]))



#|
(largest-of (list 5 23 -2 4 10 52 -10 3))
==>
(largest-of/acc (list 23 -2 4 10 52 -10 3)   5)
==>
(largest-of/acc (list   -2 4 10 52 -10 3)   23)
==>
(largest-of/acc (list      4 10 52 -10 3)   23)
==>
(largest-of/acc (list        10 52 -10 3)   23)
==>
(largest-of/acc (list           52 -10 3)   23)
==>
(largest-of/acc (list              -10 3)   52)
==>
(largest-of/acc (list                  3)   52)
==>
(largest-of/acc (list                   )   52)
==>
52
|#









