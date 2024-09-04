# Homework 3 - Containment; Object Diagrams

Create an Eclipse project named `hw03-containment`.

---

1. Create classes that capture *bank customers* and *bank accounts*. A customer has a first and last name. An account has a customer and a balance. In addition to other examples, make objects for two accounts held by the same customer.

2. Use UMLet[*see below] to draw a **class diagram** for your design. Export your diagram file as a `.uxf` file so you can re-import it later on to work on it if necessary. Export a copy also as a PDF and upload the PDF to your submission folder.

3. In the `BankCustomer` class, write a method `openAccount` that takes an initial deposit and returns a new bank account that has the initial deposit as the amount and the customer object as the customer. Write test cases for this as usual using `assertEquals`, but you might find that they do not pass when you expect them to. Just ask if so -- we need to talk about `equals()` methods...

4. In the `BankAccount` class, write a method `statusMessage` that takes no arguments and returns a string. The string should be one of `”Positive Balance”`, `”No Money”`, or `”Overdrawn”`, depending on whether the balance is positive, zero, or negative (respectively).


---
### Running UMLet
- Online: https://www.umletino.com/umletino.html
- Download standalone app: https://www.umlet.com/ 
- Eclipse plugin (it is sometimes unstable and crashes): "Help" menu -> "Eclipse Marketplace...": search for "UMLet - UML Tool for Fast UML Diagrams"




<!--
Create a class that captures *airline tickets*. Each ticket lists the departure and arrival cities, a flight number, and a *seat assignment*. A seat assignment has both a row and a letter for the seat within the row (such as 12F). Make two examples of tickets.
-->
