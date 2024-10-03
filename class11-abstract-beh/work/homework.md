# Homework 11 - Abstracting Behavior

Create an Eclipse project named `hw11-abstract-behav`.

Download the 4 files in the following folder and add to your project:
- [Book, ILoB, IBookPredicate, BookTest](../code/hw/)

## Part 1

Abstract over the `anyFiction` and `anyOver50` methods. Create a new method named `any()`. Use the existing `IBookPredicate`. Make sure you rewrite the test cases to use your `any` method.

## Part 2

How might we find the list of all nonfiction books selling for under $20? Or books costing more than $50, written by a particular author? We could continue to define new `IBookPredicate` classes for each of these *compound* properties... but notice that we already have classes for the simpler pieces of these questions. It would be a shame not to be able to reuse their implementations.

What does the `IBookPredicate` promise? It says that for any class that implements the interface, we can ask instances of that class a boolean question about a `Book` - but it says nothing about how the class should implement the answer to that question. If we wanted, we could have a class that delegates answering the question to other `IBookPredicate`s!

Design a `CompoundBookPredicate` class that works as follows. You should be able to copy/paste these tests and make them pass without editing:

```
	@Test
	public void testCompound() {
		// books > $50 and written by M.F. 
		assertEquals(new ConsLoB(this.htdp, this.mtlob),
				this.blist4.select(new CompoundBookPredicate(
										new ByAuthorPredicate(this.mf),
										new Over50Predicate())));
		
		// non-fiction books under $20
		assertEquals(new ConsLoB(this.eos, this.mtlob),
				this.blist4.select(new CompoundBookPredicate(
										new NonFictionPredicate(),
										new Under20Predicate())));

		
	}
```

