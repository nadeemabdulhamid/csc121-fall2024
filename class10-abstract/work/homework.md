# Homework 10 - Abstracting with Classes

Create an Eclipse project named `hw10-abstract`.

Download the following files and add to your project:
- [Files.java](../code/Files.java)
- [FileTests.java](../code/FileTests.java)

Imagine that a file on your computer can either be an ImageFile, TextFile, or AudioFile. Each class of data has a name and the owner, but there is additional information for each kind of file. 

## Part 1
- Lift the common fields from the classes provided to you to an `abstract` class named `AFile`. Include a constructor in the abstract class and change the constructors in the sub-classes accordingly (remember `super(...)`.). After your refactoring the tests should run/pass exactly as before with no need to change.


## Part 2

Design the following methods (remember to add the signatures to the `IFile` interface, and write test cases in the test class):

- `downloadTime` : determines how many seconds it takes to download this file at a given download rate, in bytes per second.
- `canCompress` : determines if a file can be compressed to reduce its size. All types of files can be compressed, except text files whose size is less than 100 bytes (for a file that small, compression doesn't reduce its size).

Look at the methods you've written and identify the places where your implementations are similar, and (wait for it...) abstract!!.


For each method defined in the three *concrete* sub-classes decide which category it belongs in:

1. *The implementations in the sub-classes are all different.* For this case declare the method as `abstract` in the abstract class.
2. *The implementations in the sub-classes are all the same.* For this case you can implement the method completely in the abstract class. Other implementations can be removed.
3. *The implementations in the sub-classes are the same for some, but not all.* For this case you can move the common implementation into the abstract class, and *override* the methods in the classes that require different implementation(s).

Move the methods that can be *lifted (abstracted)* and make sure all tests continue to pass.


