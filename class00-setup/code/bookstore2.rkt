;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname bookstore2) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; CSC121 Fall 2024
;; bookstore2.rkt

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
; from the template:
;  ... (book-title abook) ...  String
;  ... (book-author abook) ... Author
;  ... (book-price abook) ...  Num
;  ... (book-kind abook) ...   Symbol
;  ... (author-func (book-author abook)) ...  ??? <- add to wish list
  (author-before1950? (book-author abook)))



;; author-before1950?: Author -> Boolean
;; was this author born before 1950?
(check-expect (author-before1950? eh) true)
(check-expect (author-before1950? ebw) true)
(check-expect (author-before1950? mf) false)

(define (author-before1950? an-author)
; from the template:
;  ... (author-name an-author) ... String
;  ... (author-yob  an-author) ... Num
  (< (author-yob  an-author) 1950))



