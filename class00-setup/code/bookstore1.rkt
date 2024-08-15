;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname bookstore1) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
;; CSC121 Spring 2011
;; Lecture/Lab 1: January 13, 2011
;; bookstore1.rkt

;; A Book is (make-book String String Num Symbol)
;; There are three kinds of books: fiction, nonfiction, textbook
;; represented by symbols 'F 'N 'T
(define-struct book (title author price kind))

;; Examples of books
(define oms (make-book "Old Man and the Sea" "EH" 10 'F))
(define eos (make-book "Elements of Style" "EBW" 20 'N))
(define htdp (make-book "HtDP" "MF" 60 'T))

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
; from the template:
;  ... (book-title abook) ...  String
;  ... (book-author abook) ... String
;  ... (book-price abook) ...  Num
;  ... (book-kind abook) ...   Symbol
  (cond
    [(symbol=? (book-kind abook) 'F) (- (book-price abook) (* 0.3 (book-price abook)))]
    [(symbol=? (book-kind abook) 'N) (- (book-price abook) (* 0.2 (book-price abook)))]
    [(symbol=? (book-kind abook) 'T) (book-price abook)]))


