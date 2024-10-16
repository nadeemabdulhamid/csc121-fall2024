# Classwork 12 - Generics & Loose Ends

Create an Eclipse project named `class12-generics`.


## Tasks: Abstracting Types: Pairs

Consider the following two class definitions:

```
public class Name {
    private String first;
    private String last;

    ...default constructor
}
```

and

```
public class Posn {
    private int x;
    private int y;

    ...default constructor
}
```

1. Abstract over these two definitions to define a new class `PairSame` which has two fields, `first` and `second`, of (the same) generic type.

2. Define a `public String toString()` method for `PairSame` that returns the two components of the pair separated by a space.
   
3. Define a `swap()` method that passes the following test cases.


```
import static org.junit.Assert.*;
import org.junit.Test;

public class PairTest {
    PairSame<String> name = new PairSame<String>("Eduardo", "Liu");
    PairSame<Integer> posn = new PairSame<Integer>(31, 75);

    @Test 
    public void testPair() {
        assertEquals("Eduardo Liu", name.toString());
        assertEquals("31 75", posn.toString());

        assertEquals("Liu Eduardo", name.swap().toString());
        assertEquals("75 31", posn.swap().toString());
    }
}
```

### Concept: Wrapper classes

Note in this example we are using the wrapper class `Integer` because an `int` is not an object, whereas generic types can only by instantiated with object types. Every primitive Java type has a corresponding "wrapper class" defined for it. For more info, see:

- https://www.w3schools.com/java/java_wrapper_classes.asp
- https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html


## Tasks: Refinement

> What would need to change to support a Pair with two fields of potentially different types. What would the swap method produce?

- Consider this class:
```
public class HighScore {
    private String name;
    private int score;

    ...default constructor
}
```

4. Define a new class `Pair` that is similar to `PairSame`, but allows the `first` and `second` fields to be different things. Be sure to define a `swap()` method as well.

5. Refactor the `PairSame` class so that it `extends Pair<__, __>`  (fill in the type parameters appropriately). You should be able to *delete* all (field & method) definitions from the `PairSame` class. Just define a constructor that invokes the `super` constructor appropriately.

6. Make sure the tests in `PairTest` still work.


## Exploring: `toString()` (and more)

Work with someone next to you. Use resources on the internet (Google, ChatGPT, Copilot, Stackoverflow, whatever) to find answers to these questions. Summarize your findings in a `/*` *comment* `*/` at the bottom of your `Pair.java` file. ***Don't just write down anything that doesn't make sense to you. If you don't understand what something is saying, please ask!***

- Is the `toString()` method special in Java? How? 

- What happens if you don't define `toString()` (e.g. comment out the definition and run `PairTest`.) Where does that come from?

    > **Try this:** (With `toString()` still commented out:) Add the following method to `Pair` and try running `PairTest`. Inspect the failing method result.

    ```
    public int hashCode() { 
		return 0x95;
	}
    ```

- What is `Object`? 

- What's the relationship between `Pair` and `Object`? 


