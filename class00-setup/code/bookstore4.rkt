;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname bookstore4) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
;; CSC121 Spring 2011
;; Lecture/Lab 1: January 13, 2011
;; bookstore4.rkt

;; A Book is (make-book String Author Num Symbol)
;; There are three kinds of books: fiction, nonfiction, textbook
;; represented by symbols 'F 'N 'T
(define-struct book (title author price kind))

;; An Author is (make-author String Num)
(define-struct author (name yob))

;; Examples of authors
(define eh (make-author "Hemingway" 1900))
(define ebw (make-author "White" 1920))
(define mf (make-author "MF" 1970))

;; Examples of books
(define oms (make-book "Old Man and the Sea" eh 10 'F))
(define eos (make-book "Elements of Style" ebw 20 'N))
(define htdp (make-book "HtDP" mf 60 'T))

#|
 the sale price of the book depends on the daily discounts
 these may differ depending on the kind of book
 suppose today we have the folloiwng discounts:
 there is 30% discount on fiction books
 there is 20% discount on nonfiction books
 textbooks sell at full price
|#

;; book-sale-price: Book -> Number
;; compute the sale prices of the given book based on today's discounts
(check-expect (book-sale-price oms) 7)
(check-expect (book-sale-price eos) 16)
(check-expect (book-sale-price htdp) 60)

(define (book-sale-price abook)
  (cond
    [(symbol=? (book-kind abook) 'F) (- (book-price abook) (* 0.3 (book-price abook)))]
    [(symbol=? (book-kind abook) 'N) (- (book-price abook) (* 0.2 (book-price abook)))]
    [(symbol=? (book-kind abook) 'T) (book-price abook)]))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

#|
 Now design a function for Books that determines whether
 the author of a Book was born before 1950.
|#

;; before1950?: Book -> Boolean
;; was the author of the book born before 1950?
(check-expect (before1950? oms) true)
(check-expect (before1950? eos) true)
(check-expect (before1950? htdp) false)

(define (before1950? abook)
  (author-before1950? (book-author abook)))

;; author-before1950?: Author -> Boolean
;; was this author born before 1950?
(check-expect (author-before1950? eh) true)
(check-expect (author-before1950? ebw) true)
(check-expect (author-before1950? mf) false)

(define (author-before1950? an-author)
  (< (author-yob  an-author) 1950))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

#|
 Now suppose we have a list of Books and we want a list
 of only the Books with authors born before 1950.
|#

;; We can use the abstract function filter and the function we
;; we wrote above to produce only select items from a given list

;; FILTER DEFINITION:
;; filter: (X -> Boolean) [Listof X] -> [Listof X]
;; to construct a list from all those items on 'alox' for which 'P' holds
;; (define (filter P alox) ...)


;; all-books-before1950: [Listof Book] -> [Listof Book]
;; produce from the given list a list of all books written
;; by authors born before 1950
(check-expect (all-books-before1950 empty) 
              empty)
(check-expect (all-books-before1950 (list oms htdp eos))
              (list oms eos))
(check-expect (all-books-before1950 (list oms eos)) 
              (list oms eos))
(check-expect (all-books-before1950 (list htdp)) 
              empty)

(define (all-books-before1950 alob)
  (filter before1950? alob))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

#|
 Compute the total sale price of all books in a given list
 that are on sale today.
|#

;; total-sale-price: [Listof Book] -> Number
;; compute the total sale price of all books in the given list
(check-expect (total-sale-price empty) 0)
(check-expect (total-sale-price (list oms htdp eos)) 83)
(check-expect (total-sale-price (list oms eos)) 23)
(check-expect (total-sale-price (list htdp)) 60)

;; IDEA:
;; we can produce a list of all sale prices and then add all items in the list

(define (total-sale-price alob)
  (foldr + 0 (map book-sale-price alob)))

;... can we do this better? ... to add the prices as we go?
(total-sale-price (list oms htdp eos))
