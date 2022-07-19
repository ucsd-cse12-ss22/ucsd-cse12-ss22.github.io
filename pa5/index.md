---
layout: pa
title: "PA5: Hash Map and BST"
doodle: "../doodle.png"
---

---
**This assignment is closed to collaboration.**

This assignment will teach you how to implement a Hash Map and a Binary Search Tree and use them to implement a basic file searching system that can order and filter data from a text file. 

## Deadlines

This PA is due on **Thursday, July 28, at 11:00pm PDT** 

## Resources

Link to FAQ: [https://piazza.com/class/kirvel5rj2337n](https://piazza.com/class/kirvel5rj2337n)

Link to PA Video: [https://canvas.ucsd.edu/courses/21784/external_tools/82](https://canvas.ucsd.edu/courses/21784/external_tools/82)

## Getting the Code

The starter code is in the Github repository at [https://github.com/ucsd-cse12-ss22/PA5_starter_code](https://github.com/ucsd-cse12-ss22/PA5_starter_code). If you are not familiar with Github, here are two easy ways to get your code.

1. Download as a ZIP folder 

   If you scroll to the top of Github repository, you should see a green button that says *Code*. Click on that button. Then click on *Download ZIP*. This should download all the files as a ZIP folder. You can then unzip/extract the zip bundle and move it to wherever you would like to work. The code that you will be changing is in the folder called *pa5-starter*.

2. Using git clone (requires terminal/command line)

   If you scroll to the top of the Github repository, you should see a green button that says *Code*. Click on that button. You should see something that says *Clone with HTTPS*. Copy the link that is in that section. In terminal/command line, navigate to whatever folder/directory you would like to work. Type the command `git clone _` where the `_` is replaced with the link you copied. This should clone the repository on your computer and you can then edit the files on whatever IDE you see fit.

If you are unsure or have questions about how to get the starter code, feel free to make a Piazza post or ask a tutor for help.

## Part 1: Hash Map and BST Implementations of `DefaultMap` (36 points)
---


### Hash Map Implementation (**TODO** - 18 points)
---

You’ll provide a Hash Map based fast implementation of an interface called `DefaultMap` in `MyHashMap.java`.  

You will implement all the methods defined in the `DefaultMap` interface. Using [amortized analysis](https://en.wikipedia.org/wiki/Amortized_analysis), you must ensure that each has the specified big-O bound and argue why based on the documentation of any libraries you use or based on your implementation. In each, _n_ represents the number of entries in the map.  
Here is a helpful link to learn more about amortized analysis that gives an example with a dynamic array: http://www.cs.cornell.edu/courses/cs3110/2011sp/Lectures/lec20-amortized/amortized.htm

- `put`, required O(1)
- `replace`, required _O(1)_
- `remove`, required _O(1)_
- `set`, required _O(1)_
- `get`, required _O(1)_
- `size`, required _O(1)_
- `isEmpty`, required _O(1)_
- `containsKey`, required _O(1)_
- `keys`, required _O(n)_

In `MyHashMap.java` you will implement a single constructor that takes two arguments (the initial capacity and the load factor). This is where you will initialize the instance variables. 
 
#### `HashMapEntry<K, V>`

Within `MyHashMap.java`, you are provided the private inner class `HashMapEntry<K, V>`. Use this class to represent your key value pairs in your HashMap. Note it implements the `DefaultMap.Entry<K, V>` interface. Each `HashMapEntry` object has two instance variables (`K key`, `V value`). Use the getters/setters from this class to get the key values and set the values. 

#### Instance Variables

- `loadFactor`: the load factor for when to increase the capacity of the HashMap (default = 0.75)
- `capacity`: the overall capacity of the HashMap (initial default = 16)
- `size`: the number of elements in the HashMap
- `buckets` or `entries`: If you would like to using Separate chaining conflict resolution, use the List array `buckets`. If you would like to use Linear Probing for your conflict resolution, use the array `entries`. For either case, `buckets` or `entries` is where your elements will be stored. However, we **strongly recommend** handling collision using **separate chaining**. 

**Note:** `initialCapacity` must be *non-negative* and `loadFactor` must be *positive*. If either of these conditions are violated, you must throw an `IllegalArgumentException` in your constructor with the appropriate error message. 

The specifications for the other methods are defined in header comments in the `DefaultMap.java` file, which you should follow. You may use any methods in the Java collections library to implement them (including helpers like `Collections.sort`). If you don't know how to use a particular library method, interface, or class in the standard Java utils, ask! This is an opportunity to learn about the built-in libraries.
***Note:*** You are not allowed to use the java HashMap library!!!

You may find these useful:
- [`Set`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html)
- [`Collection`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html)

The pages linked from those may also have useful information. For specific hash map implementation detail, please follow your implementation based on lecture. Your implementation of `DefaultMap` will be graded automatically by tests that we provide. 

**Note:** Please make sure that you test your MyHashMap implementation thoroughly before proceeding to part 2 as part 2 uses your implementation of MyHashMap.


### BST Implementation (**TODO** - 18 points)
---

You’ll provide a Binary Search Tree based fast implementation of an interface called `DefaultMap` in `BST.java`.

You will implement all the methods defined in the `DefaultMap` interface, but now for Binary Search Tree based implementation. You must ensure that each has the specified big-O bound in the **worst case**, and argue why based on the documentation of any libraries you use, or based on your implementation. Note that these are big-O bounds, so doing _better_ (like O(1) where O(log(n)) is required) is acceptable. In each, _n_ represents the number of entries in the map.

- `put`, required O(n)
- `replace`, required _O(n)_
- `remove`, required _O(n)_
- `set`, required _O(n)_
- `get`, required _O(n)_
- `size`, required _O(1)_
- `isEmpty`, required _O(1)_
- `containsKey`, required _O(n)_
- `keys`, required _O(n)_

In `BST.java`, you will need to come up with the proper instance variables to achieve the above runtime requirements.

The specifications for the other methods are defined in header comments in the `DefaultMap.java` file, which you should follow. 

**Important:** for keys(), the returned result need to be in ascending order

***Note:*** You are **not allowed** to use the java `SortedMap` interface or `Collections.sort`, or any other implementations of BSTs or sorting!!!

Your implementation of `DefaultMap` will be graded automatically by tests that we provide. We’ll provide a very minimal sanity check in the grader. DO NOT rely on it for testing!


## Part 2: File System Implementation (16 points)
---

In part 2, you are asked to implement a basic unix file system structure to support file look up methods. It is shown in the log history that users tend to search files either by their names, their directories, or their modified dates. After implementing `MyHashMap.java` and `BST.java` in part 1, you think that Hash Map and Binary Search Tree will be perfect data structures for this task to perform these searches in an efficient way. Your task is to design a simplified file system structure with a Hash Map and a Binary Search Tree that can support user defined filtering methods while making sure that those filtering methods are performed in an efficient way.

You should **only modify** `HashMapFileSystem.java` and `BSTFileSystem.java` for Hash Map and BST based implementations of the file system, `FileData.java` has already been implemented for you.

*Note*: It's likely that you need to store multiple files with the same name in your computer, therefore our file system supports duplicate files with the same name or date in different directories. However, the name should always be unique in each directory.

### FileData (**Already Implemented**)
---
In our file system, a file is represented as a `FileData` object which contains the information of its name, directory, and last modified date. 

#### Instance Variables

##### `name`

The name of the given file in string format.

##### `dir`

The directory of where the file is stored in, represented in a string format.

##### `lastModifiedDate`

The date of when the file is last modified, represented in a string format.

#### Methods

In FileData.class, the following methods have already been implemented:

- `public FileData(String name, String directory, String modifiedDate)`
- `public String toString()`

##### `public FileData(String name, String directory, String modifiedDate)`

A *Constructor* that creates an instance of `FileData` object by intializing its instance variables with the given parameters. It is assumed that the parameters passed in to the constructor will be non-null.

##### `public String toString()`

A method that returns the string representation of FileData by displaying the file information. It strictly follows the format of `{Name: file_name, Directory: dir_name,  Modified Date: date}`.


### FileSystem (**TODO** - 16 points)
---

`HashMapFileSystem` and `BSTFileSystem` classes are used to represent the entire structure of the Hash Map/BST implementations of our file system. You should store file's information in the instance variables provided corresponding to each of the Hash Map/BST implementations (shown below) to ensure that the look up times are as efficient as possible. You are **NOT ALLOWED** to add any additional instance variables or include any additional imports in `HashMapFileSystem.java` or `BSTFileSystem.java`.

#### Instance Variables for Hash Map Implementation
---

##### `nameMap`

A MyHashMap that uses file's name as the key and a list of FileData as the value.

<img src="https://i.imgur.com/S2bucAA.png" width="450">

<!-- ![](https://i.imgur.com/S2bucAA.png) -->
**Illustration to show that "test.txt" is an entry within nameMap that uses filename (String) as a key that maps to an arraylist of all fileData with the same filename but in a different directory.*

##### `dateMap`

A MyHashMap that uses file's date as the key and a list of FileData as the value.

<img src="https://i.imgur.com/DSqDRBz.png" width="450">

<!-- ![](https://i.imgur.com/DSqDRBz.png) -->
**Illustration to show that "02/01/2021" is an entry within nameMap that uses file's lastModifiedDate (String) as a key that maps to an arraylist of all fileData with the same lastModifiedDate.*


#### Instance Variables for BST Implementation
---

##### `nameTree`

A BST that uses the file name as the key and the `FileData` as the value.  

<img src="https://i.imgur.com/io0Fayy.png" width="450">

<!-- ![](https://i.imgur.com/io0Fayy.png) -->

##### `dateTree`

A BST that uses the file date in a different format (format: yyyy/mm/dd) as the key and a list of FileData as the value. This list should keep track of the files in the order that they arrive in.   

<img src="https://i.imgur.com/hlOvqBl.png" width="450">

<!-- ![](https://i.imgur.com/hlOvqBl.png) -->

##### `dc`

A `DateComparator` that is used to compare the date on the files.

#### Inner Class `DateComparator` (specific to BST Implementation only) 

At times, we may want to create custom ways to compare two objects. To support this, Java has a built-in interface called Comparator that expresses this idea of user-defined comparisons. An implementatation of Comparator provides a single method, called compare, that takes two elements of a particular type and returns a negative number if the first is “smaller” than the second, 0 if they are equal, and a positive number if the first is “larger” than the second.

Comparators can be particularly useful when we may want to compare items by different criteria. For example, we may have a class defining a person:

```
class Person { String name; int age; }
And sometimes we want to order People by name, and other times by age. We could define a Comparator for each of those cases:

class AgeComparator implements Comparator<Person> {
  public int compare(Person p1, Person p2) { return p1.age - p2.age; }
}
class NameComparator implements Comparator<Person> {
  public int compare(Person p1, Person p2) { return p1.name.compareTo(p2.name); }
}
```

For our purposes, we want to be able to easily compare the last modified date without worrying about the format. To do this, we will create a class called `DateComparator` inside of `BSTFileSystem.java` that will switch the given dates to the correct format and then compare them. 

##### `compare` Method

`public int compare(String date1, String date2)`  
Given two strings that contain the last modifed date, if `date1` is more recent than `date2` return 1, if `date1` is less recent than `date2` return -1 and if `date1` is equal to `date2` return 0. For example, `01/01/2021` is less recent than `01/02/2021` - thus `compare("01/01/2021", "01/02/2021")` should return -1. Similarly, `12/01/2020` is less recent than `01/01/2021` and should return -1. You can assume that none of the inputs are null.

Hint: You might want to change the format of the dates   

Additionally, please note that `Comparator` and `Comparable` are **not** the same thing. If you are curious, here are the links to the Java docs: 

Comparator: https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html 
Comparable: https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html


#### Methods to be completed for Hash Map implementation (**TODO** - 8 points)
---

In `HashMapFileSystem.java`, you will implement and thoroughly test the following methods:

##### `public HashMapFileSystem()`

Default constructor that creates a new `HashMapFileSystem` object and initializes its instance variables.

##### `public HashMapFileSystem(String inputFile)`

*Constructor* that creates a new `HashMapFileSystem` object with the given `inputFile` that contains the Hash Map based file system information. We have provided some skeleton code for reading the contents of the text file. You will need to initialize HashMapFileSystem's instance variables and populate HashMapFileSystem with each file's information. Each file information is represented by a line formatted as `filename, directory, date` within the content of `inputFile`. For example, it could be `mySample.txt, /home, 02/01/2021`. (Note that since it is a unix type file system, forward slashes are used to represent directory hierarchy). We have also provided a sample file, `input.txt`, to show how each file information is represented within the inputFile. Feel free to add more data to the file to test your HashMapFileSystem implementation thoroughly. You may assume that `inputFile` parameter is properly formatted and is non-null.

##### `public boolean add(String fileName, String directory, String modifiedDate)`

This method should create a FileData object with the given file information and add it to the instance variables of HashMapFileSystem. This method should return true if the file is successfully added to the HashMapFileSystem, and false if a file with the same name already exists in that directory. The default values for `filenName`, `dir`, and `modifiedDate` are `""`, `"/"`, `"01/01/2021"` in case any of these variables is null.

##### `public FileData findFile(String name, String directory)`

This method should return a single FileData object with the given name and directory. You should not modify the HashMapFileSystem itself. Return null if such a file does not exist.  


#### Methods to be completed for BST implementation (**TODO** - 8 points)
---

In `BSTFileSystem.java`, you will implement and thoroughly test the following methods:

##### `public BSTFileSystem()`

Default constructor that creates a new `BSTFileSystem` object and initializes its instance variables.

##### `public BSTFileSystem(String inputFile)`

*Constructor* that creates a new `BSTFileSystem` object with the given `inputFile` that contains the BST based file system information. We have provided some skeleton code for reading the contents of the text file. You will need to initailizes BSTFileSystem's instance variables and populate BSTFileSystem with each file's information. Each file information is represented by a line formatted as `filename, directory, date` within the content of `inputFile`. For example, it could be `mySample.txt, /home, 02/01/2021`. (Note that since it is a unix type file system, forward slashes are used to represent directory hierarchy). We have also provided a sample file, `input.txt`, to show how each file information is represented within the inputFile. Feel free to add more data to the file to test your BSTFileSystem implementation thoroughly. You may assume that `inputFile` parameter is properly formatted and is non-null.

##### `public void add(String name, String dir, String date)`

This method should create a FileData object with the given file information and add it to the instance variables of BSTFileSystem. If there is a duplicate file name, then the FileData with the most recent date should be used. For example, if the first FileData stored in the trees is `test.txt, /home, 01/01/2021` and the next FileData is `test.txt, /home, 01/02/2021`, the second FileData should *replace* the first FileData stored in the trees. If the `name`, `dir`, or `date` is `null`, then do not add anything to the BSTFileSystem.

##### `public ArrayList<String> findFileNamesByDate(String date)`

Given a `date` (format: mm/dd/yyyy), return an ArrayList of file names that correspond to this date. This list should have the file names in the order that they were added. If the `date` given is `null`, return `null`.

##### `public BSTFileSystem filter(String startDate, String endDate)`

Given a `startDate` and an `endDate` (format: mm/dd/yyyy), returns a new BSTFileSystem that contains only the files that are within the range (`startDate` is inclusive, `endDate` is exclusive). Assumes the given parameters are valid and non-null.  

Example: Let's call `filter("01/20/2021", "02/02/2021")` on a `BSTFileSystem` with the following `dateTree`:   

<img src="https://i.imgur.com/dlQBJfT.png" width="450">

<!-- ![](https://i.imgur.com/dlQBJfT.png) -->

It returns a **BSTFileSystem** with a `dateTree` that looks like the following (note: there should be a populated `nameTree` with the same entries):   

<img src="https://i.imgur.com/jDzGOt0.png" width="450">

<!-- ![](https://i.imgur.com/jDzGOt0.png) -->


## Testing (2 points)
---

In the starter code, there are two files where you will add tests:
- MyHashMapTest.java
- BSTTest.java

Write at least **two** tests per file and submit these to Gradescope along with your implementations. This section will be graded based on completion. 


## Part 3: Gradescope Assignment (9 points)
---

### Gradescope Question

Respond to the following prompts in the Gradescope assignment: **PA5-written**:

1. For each method in `MyHashMap` (excluding `size` and `isEmpty`), argue why its performance meets the specified required bound.
2. Justify the runtime bounds (worst case) for the methods you wrote in `BST`.
3. Describe what the best case would be for a non-empty BST, specifically, what does the tree look like? How is this the best case? What methods benefit from the best case scenario? 


## Style (4 points)
The following files will be graded on style:
* MyHashMap.java
* BST.java
* HashMapFileSystem.java
* BSTFileSystem.java

On this PA, **all guidelines must be followed**, the guidelines are summarized below: 

- file headers required
- method headers (not required for test methods)
- Lines cannot be longer than 100 characters
- Inconsistent indentation not allowed
- Lines **must not** be indented more than 6 times. If you have a need to indent more than 6 levels, build a helper method or otherwise re-organize your code
- Test method must have meaningful names
- Helper method must have meaningful names
- descriptive variable names


## Submitting

### Part 1 & 2

On the Gradescope assignment: **PA5-code** please submit the following files:

* MyHashMap.java
* MyHashMapTest.java
* BST.java
* BSTTest.java
* HashMapFileSystem.java
* BSTFileSystem.java

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

### Part 3

Please submit your answers to the questions from part 3 on the Gradescope assignment: **PA5-written**. You may submit as many times as you like till the deadline.


## Scoring (67 points total)

- 18 points: HashMap implementation of `DefaultMap` [automatically graded]
- 18 points: BST implementation of `DefaultMap` [automatically graded]
- 8 points: Implementation of `HashMapFileSystem` [automatically graded]
- 8 points: Implementation of `BSTFileSystem` [automatically graded]
- 2 points: MyHashMapTest and BSTTest graded on completion [manually graded]
- 9 points: Gradescope Questions [manually graded]
- 4 points: Style [manually graded]

There is no bad implementation testing on this PA. However, we highly recommend you use the practices you know from testing to thoroughly check that `MyHashMap.java`, `BST.java`, `HashMapFileSystem.java`, and `BSTFileSystem.java` you wrote work as expected.
