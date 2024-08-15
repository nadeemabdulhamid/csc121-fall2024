---
marp: true
theme: gaia
class: invert
paginate: false


---
# Lecture 0 - Welcome (Back)!
CSC 121 - Object Oriented Program Design
Nadeem Abdul Hamid - Fall 2024

<!-- paginate: skip -->
<!-- _class: lead -->


---
## Today
- Course syllabus
- Review
    - Designing programs, data definitions
- Tools
    - Download and install Eclipse IDE and Java JDK
    - Create and run an Eclipse project


<!-- paginate: true -->
<!-- footer: Lecture 0 - Welcome -->


---

<img height="50%" src="https://upload.wikimedia.org/wikipedia/commons/7/79/Agc_view.jpg" alt="Apollo computer and DSKY">

<img align=right height="100%" src="https://upload.wikimedia.org/wikipedia/commons/0/04/Apollo_11_Lunar_Lander_-_5927_NASA.jpg" alt="Apollo 11 lunar lander">

Apollo 11 Lunar Module *Eagle*, 1969

<small style="font-size: 50%;">The Apollo computer had less than 80K bytes of memory: https://en.wikipedia.org/wiki/Apollo_Guidance_Computer</small>

<!--

Take yourself back in time to the early 1960s. None of us have been born (even the professor). The US and Russia have started the space race, but have not yet gotten to the moon. Microchips have just been invented. They replace large vacuum tubes (that used to be use in fat-backed TVs and monitors). The Apollo-mission computers are among the first to use the new microchips (which allow computers to start becoming smaller than this classroom). The amount of memory on the Apollo-mission computers is less than what you need to store 5% of a picture taken with a modern smartphone.
(The Apollo computer had less than 80K bytes of memory: https://en.wikipedia.org/wiki/Apollo_ Guidance_Computer)

And they navigated to and landed on the moon with that!

Okay, neat history, but why are we starting CSC121 this way?

Because if you want to understand a new technology or a new idea, you need to know the context of what was going on when it arose. Historians know this, but it’s something we often overlook in CS. That’s a pity, because knowing the context provides a lot of the texture in any field, and some ideas about why the new thing was designed the way it was.

In the mid 1960s, a group of computer scientists in Norway were trying to figure out how to use computers to tackle other new problems as well. They wanted to create software that could simulate physical systems that responded to events (like people pushing elevator buttons, or trains arriving at signal crossings). The programming languages of the day weren’t proving up to the task. So these scientists, Kristen Nygaard and Ole-Johan Dahl (with help from some others) invented a new language called SIMULA. It was the first so-called “object-oriented” language. They won the Turing award (the “Nobel prize” of Computer Science) for this work.

And this semester, we are going to teach you object-oriented programming using Java, which descends from SIMULA.

But we aren’t here just to teach you object-oriented programming. We’re here to teach you fundamental principles of computer science, including data structures, analysis, software design, and testing. All of which are driven by needs to build computing systems that are efficient, robust, and maintainable. We start this course tipping our hats to the early pioneers of computing who did amazing things with limited technology, as we help prepare all of you to do amazing things with powerful technology.

Because the designers of SIMULA did one of the most fundamental tasks in computing: they tried to tackle a new kind of problem, realized they couldn’t express the problems cleanly, and built a new language to make their lives easier. One of the most powerful and beautiful things about computing is that we get to define how our systems work. We aren’t like the physical scientists, stuck to working with what nature gave us. We build our tools, our systems, our tools (sometimes, those tools cause new problems— that’s another important part of the story).

To help prepare you to do that, we need to expose you to different ways of expressing problems. That's part of our curriculum here at Berry!
-->



---
## Course Overview

- Canvas site: http://cs.berry.edu/csc121
- Syllabus

- Contents
    - Introduction to object-oriented programming ...
    - ... with a strong software engineering foundation ...
    - ... aimed at producing and maintaining large, high-quality software systems.


---
## Goals

- Understand how to design programs using the object-oriented paradigm
- Demonstrate the ability to implement these designs
- Produce well-documented implementations
- Gain exposure to state-of-the-art development tools
- Use critical thinking skills and creativity to solve problems


--- 
## Components

- 10% Class attendance/participation
- 50% Programming assignments
- 10% Semester project (group)
- 10% Quizzes (~ weekly)
- 20% Exams (midterm + final)


---
<style scoped>ul, p  { font-size: 80%; }</style>
## Programming assignments

- Assigned ~daily
- Complete/incomplete + rework
- Will be substantial: the bulk of work outside class
- You're expected to face challenges!

### Getting Help 
- Student hours
- Ask on Discord
- Email
- Peer TAs 


---
## Course Policies

- Pair Programming 
    - allowed for programming assignments; must work together, at the same time & place
- Computers
- Late Work
    - ***Don’t Leave Work To The Last Minute***
- Accommodations
- Academic Integrity


---
<style scoped>ul, p  { font-size: 80%; }</style>

## Generative AI

**The use of Internet q&a sites or generative AI tools to complete assignments is prohibited for this course.** These have the potential to be useful for experienced developers and/or niche tasks. However, just as using a life vest (PFD) while learning to swim is [*counterproductive, detrimental, and even dangerous*](https://texasswimacademy.com/personal-flotation-devices-are-they-helpful-or-hurtful-when-learning-how-to-swim/), relying on such tools will impede and prolong the process of your learning the material that this course covers.
> In an introductory programming course, ... GAI code generation is ***actively harmful to student learning***. [[Cornell University report](https://teaching.cornell.edu/generative-artificial-intelligence/cu-committee-report-generative-artificial-intelligence-1)]

- If anyone is found to be using ChatGPT or similar tools to generate code solutions for assignments in this course, without express permission or direction to do so, they will be withdrawn administratively from the course.


---
## Course Project

- Work in groups of 2 or 3
- Program an interactive graphical simulation or computer game of your choice and design
- Grade heavily weighted by fair and substantial contribution to the code repo
- More details later ...


---
## Textbook

- [How to Design Classes (HtDC)](https://felleisen.org/matthias/HtDC/htdc.pdf) (online pdf) 
    (optional) Reading to follow along with lecture topics, first 7-8 weeks


---
## Course Software

### [Eclipse IDE](http://eclipse.org/downloads/)
Install Eclipse IDE *and* OpenJDK

- [Installing Eclipse IDE](https://youtu.be/A3wRGdhu55Y) (4:18)
- [Eclipse - first steps](https://youtu.be/nlxNO7Ntj_w) (5:37)

### [Github Desktop](https://desktop.github.com/)

-  Use to synchronize notes and code from Github repository


---
## Reminder
<style scoped>li, p  { font-size: 90%; }</style>

- This class is not (just) about Java. It’s about how to design programs.
    - Java is our tool as we study the principles of computation from an object-oriented perspective
    - We will cover a subset of features of Java
    - The concepts we do cover are applicable to many object-oriented languages
    - The curriculum and topics in this course follow the state of the art in the real world, w.r.t. software design and development

Those with prior Java experience likely learned different ways to do some of what we cover here. Hold tight – we’ll explain why we are doing things differently as we go.

---
## The Design Recipe

- Problem Analysis & Data Definition (& Examples)
- Signature, Purpose/Effect Statements, Function Header
- Function Examples
- Function Template
- Function Definition (Body)
- Test!


---
## The Design Recipe
<style scoped>li li  { font-size: 80%; }</style>
 
1. Problem Analysis & Data Definition/Examples
    - What kinds of data are involved? Create data definitions. Construct examples according to the data definitions, just to make sure they work.

2. Signature, Purpose/Effect Statements, Function Header
    - What kinds of data does the function consume? Which kind does it produce? And what is its purpose? (in one line)

3. Function Examples
    - Can you make up examples of inputs? What should the function produce for these inputs?

---
## The Design Recipe
<style scoped>li li  { font-size: 80%; }</style>
 
4. Function Template
    - Does the data definition (of the main argument) mention clauses? If so, use a *cond* with as many cases as there are clauses in the data definition.
    - How can you distinguish these kinds of data with conditions involving the main parameter?
    - Are structs involved? If so, write down all the selector expressions. (Do so on a per-clause basis.)
    - Does the data definition involve any self-references (or cross-references)? If so, use recursion in the template to express these "arrows”.

---
## The Design Recipe
<style scoped>li li  { font-size: 70%; }</style>
 
5. Function Definition (Let’s code!)
    - Can you deal with the simple *cond* cases? Your examples should cover those cases directly.
    - What do the expressions in the recursive cases compute? Use the purpose statement of the function to figure out what the recursive function application computes.
    - How can you combine the results of these expressions so that the function returns the desired value? Use the examples to tabulate the values of the intermediate expressions and the desired output for the given input. This will usually suggest an expression for combining the intermediate results, though admittedly this is the one and only "deep" step of design and you won't get away without some real thinking here.

6. Tests 
    - Turn the examples into tests.


---
## Data Definitions
<style scoped>li { font-size: 80%; }</style>
 
> Computers do not work with *information*: they work with *data*, which is a *representation* of the information relevant and suitable for *computation*.

- With any computation/process, you must first understand the information that is provided, and then how it is represented as data that a program manipulates
- We’ll review what we already know about data definitions in Racket and then look at how we represent the same information as data in a different language (Java)
    - However the data is represented, it is important to understand that the information is the same
    - The structure of the data representation is essentially identical in two different programming languages


---
## For later reference

- Defining compound data; functions on compound data: [bookstore1.rkt](code/bookstore1.rkt)
- Defining compound data that contains compound data; wish lists: [bookstore2.rkt](code/bookstore2.rkt)
- Defining lists of data; functions on lists of data: [bookstore3.rkt](code/bookstore3.rkt)
- Racket loops: [bookstore4.rkt](code/bookstore4.rkt)
