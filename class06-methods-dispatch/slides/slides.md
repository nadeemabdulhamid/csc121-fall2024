---
marp: true
theme: gaia
class: invert
paginate: false



---
# Lecture 6 - Types • Method Dispatch • Libraries & GUIs
CSC 121 - Object Oriented Program Design
Nadeem Abdul Hamid - Fall 2023

<!-- paginate: skip -->
<!-- _class: lead -->



---
## Objectives
<style scoped>ul  { font-size: 80%; }</style>

At the end of this lecture you should
- KNOW:
    - That types tell you what you can do with a piece of data in Java
    - That a variable whose type is an interface can only be assigned to an instance of a class that implements the interface
    - That when an instance of a class invokes a method, the method definition lookup is ***dispatched*** to the class to which the instance belongs
    - That Java programs should not have conditionals on the type of an object (Java's **method dispatch** obviates the need for a conditional)
    - How methods work when applied to objects

- BE ABLE TO:
    - Set a breakpoint and use the debugger tool to step through program execution in Eclipse

<!-- paginate: true -->
<!-- footer: Lecture 6 - Types • Method Dispatch -->



---
## Animal code examples

[code](../code/)


---
## Runtime Polymorphism in Java

- The mechanism of picking a method out of several based on its class is called ***POLYMORPHIC METHOD DISPATCH***. 
    - "*poly*" = many ; "*morphs*" = forms
    - In this context, the word ***“polymorphic”*** refers to the fact that any class that implements a particular interface supplies a definition for the methods in the interface, but each of the method definitions is unique.

Also known as "dynamic method dispatch" or "runtime polymorphism"



---
## Libraries & GUIs

Goal: *Students will demonstrate the ability to learn a new language, library, or framework on their own and use it to implement a project of their own design.*

For this course: a GUI framework based on the `core` [Processing](https://processing.org/reference) API.

- Setup (add to a new Eclipse project):
    - [core.jar](../../worlds/core.jar)
    - [IWorld.java](../../worlds/IWorld.java)
    - [AppTemplate.java](../../worlds/AppTemplate.java)



--- 
## Reading
- Section 13 – Types, Classes, and How Method Calls Compute
