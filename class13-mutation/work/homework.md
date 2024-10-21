# Classwork 13 - Mutation

Create an Eclipse project named `hw13-mutation`.

## Tasks

Start with these definitions:

```
interface IPerson {
}

class Unknown implements IPerson {

    @Override
	public boolean equals(Object other) {
		return this.getClass() == other.getClass();
	}

}

class Person implements IPerson {
}
```

For now, we will assume that everyone has at most one child. Add fields (`name`, `mom`, `dad`, `child`) and methods so that the test class below works.

1. Define two overloaded constructors. One takes just a name and initializes a Person's mom and dad to unknowns. The second one takes parents and should set each of the parents' `child` to 

2. Add an `updateChild(IPerson child)` method to the class hiearchy. For unknowns, this method does nothing. For a `Person` it sets their child. 

```
class PersonTest {
	
	Person aliya = new Person("Aliya");   // mom
	Person burhan = new Person("Burhan"); // dad
	Person camile = new Person("Camile", aliya, burhan);
	
	@Test
	void test() {
		assertEquals(camile, ((Person)camile.mom).child);
		assertEquals(camile, ((Person)camile.dad).child);
		assertEquals(new Unknown(), ((Person)camile.mom).dad);
		assertEquals(new Unknown(), ((Person)camile.dad).mom);

		assertEquals( aliya, ((Person) ((Person)aliya).child).mom );
		assertEquals( burhan, ((Person) ((Person)burhan).child).dad );
	}
}
```

3. Note: using type casts for objects like in the code above is a "code smell" and should be avoided in normal code. Sometimes, in a test class like the one above, it might be necessary to use them. Explain in a comment at the top of your PersonTest file: why are the casts `(Person)` necessary here?

4. Make sure `equals()` does not cause an infinite loop. Add the following tests. (How do you propose to modify the default `equals()` method created by Eclipse?)

```
	Person aliya1 = new Person("Aliya");   // mom
	Person burhan1 = new Person("Burhan"); // dad
	Person camile1 = new Person("Camile", aliya1, burhan1);

	@Test
	void testEquals() {
		assertEquals(true, aliya.equals(aliya1));
		assertEquals(false, camile.equals(aliya1));
	}
```


