# Homework 2 - Methods ; Conditionals

- Make a duplicate copy of your `hw01` project and name it: **`hw02-methods`**. <br>(You can select the project, copy it (Ctrl/Cmd+c) and paste it (Ctrl/Cmd + v) in your workspace, and Eclipse will ask you what you want to rename it.)
- Remember to create separate `xyzTest` classes for examples/JUnit tests for each task.

---
1. In the `Planet` class, write out a method ***template*** after the constructor. Then, add a ***stub*** for a method `convertWeight` that takes the weight of an object on earth (as a number of type `double`) and produces the corresponding weight on that planet. The intent is to multiply the given weight by the planet's gravity relative to earth’s. Write ***test cases*** for the method in a test class. ***DO NOT*** implement the method completely -- you should just have a stub that fails (most of) the test cases.


---
2. As you work on this task, you should write a stub initially; then comment it out after you have written test cases, and write out the complete definition of the method. 

   In the `Automobile` class, add a field, `tankCapacity`, which represents the number of gallons the fuel tank will hold when full. *Make sure to update the constructor appropriately.*
   
   Then, add a method `range(double percent)` that takes a percentage (as a number between `0.0` and `1.0`) representing how full the tank currently is, and produces the estimated number of *whole* miles that can be driven before it is empty. However, used cars get only 90% of their stated mileage per gallon. For example, a used new car that gets 30 mpg, with a half-full 20 gallon fuel tank, can go for another 270 miles before empty.


---
3. Develop the following method for your `Rational` class:
   * `public String toString()` - produces a String representation of the rational number, e.g. `"1/2"`. (For reasons we will cover later, your method header should have a `public` annotation before the return type `String`, as shown.)
     * If the rational number is a whole number, e.g. the denominator is `1`, like `3/1`, then produce simply the numerator as a string, e.g. `"3"`. 
     * If the numerator is `0`, then produce `"0"`. Provide test cases for your existing examples.
     * Think carefully about other scenarios that could occur with the numbers.

    > String concatenation in Java is performed using the `+` operator, like this:  `"hello" + "world"`.  If one of the operands is not a string already, Java will convert it to a string, like: `"hi" + 3` evaluates to `"hi3"`.


---
4. Add the following method to your `Rational` class. (Copy/paste it right after the constructor.) It uses Euclid's algorithm to find the greatest common divisor (GCD) of two numbers. 

   Add code to your `Rational()` constructor that uses `gcd()` to ensure that the numerator and denominator never have any common factors by simplifying the fields as they are initialized. __Work out test cases first__ and then __ask for help__ if you are not sure how to proceed.

        // produces gcd(|m|, |n|)
        private static int gcd(int m, int n) {
            if (m < 0) m = -m;
            if (n < 0) n = -n;
            if (0 == n) return m;
            else return gcd(n, m % n);
        }
    
    After doing this, you may need to adjust some of your `toString` tests, because fractions should be simplified as they are constructed.


---
5. Develop the following methods in your `Rational` class:
   * `Rational plus(Rational that)` - produces the sum of this number and that
   * `Rational minus(Rational that)`
   * `Rational times(Rational that)`
   * `Rational dividedBy(Rational that)`

    Write tests following a pattern like this, using your `toString()` method:

       Rational x1 = new Rational(1, 2);
       Rational x2 = new Rational(1, 3);
       Rational x1_plus_2 = x1.plus(x2);  // 1/2 + 1/3 = 5/6

       assertEquals("5/6", x1_plus_2.toString()); // compare the expected string representation

    You should put all tests related to a single operation (e.g. plus, minus, etc.) in a single test method in your test class. That is, define test methods named  `testPlus`, `testMinus`, etc., each containing several tests focused on that particular operation.

    Note the following formulas for rational operations: 
    - $\frac{a}{b} + \frac {c}{d} = \frac{ad+cb}{bd}$ 

    - $\frac{a}{b} - \frac {c}{d} = \frac{ad-cb}{bd}$

    - $\frac{a}{b} \times \frac {c}{d} = \frac{ac}{bd}$

    - $\frac{a}{b} \div \frac {c}{d} = \frac{ad}{bc}$ 

<!---
(boolean equals(Object that) - is this number equal to that ? (You will need to ask for help from me on this.))
-->


## Rubric

- Correct Java syntax: compiles & runs
- Purpose comments for every method (in `/** JavaDoc notation */`)
- Sufficient and correct test cases for every method
- Implementation is correct overall

