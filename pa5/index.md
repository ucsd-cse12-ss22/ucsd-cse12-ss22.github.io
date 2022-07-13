---
layout: pa
title: "PA5: Hash Map and BST"
doodle: "../doodle.png"
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


## Part 2: File System Implementation (8 points)
---

In part 2, we implement a basic unix file system structure to support file look up methods. It is shown in the log history that users tend to search files either by their names, their directories, or their modified dates. After implementing `MyHashMap.java` and `BST.java` in part 1, you think that either of Hash Map or Binary Search Tree will be a perfect data structure for this task to perform these searches in an efficient way. We design a simplified file system structure with a Hash map and a Binary Search Tree that can support user defined filtering methods while making sure that those filtering methods are performed in an efficient way.

You should **only modify** `FileData.java` for implementation of the file system, `FileSystem.java` has already been implemented. 

*Note*: It's likely that you need to store multiple files with the same name in your computer, therefore our file system supports duplicate files with the same name or date in different directories. However, the name should always be unique in each directory.

### FileData (**TODO** - 8 points)
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

In FileData.java, you will implement and thoroughly test the following methods:

- `public FileData(String name, String directory, String modifiedDate)`
- `public String toString()`

##### `public FileData(String name, String directory, String modifiedDate)`

A *Constructor* that creates an instance of `FileData` object by intializing its instance variables with the given parameters. You may assume that the parameters passed in to the constructor will be non-null.

##### `public String toString()`

A method that returns the string representation of FileData by displaying the file information. It should strictly follow the format of `{Name: file_name, Directory: dir_name,  Modified Date: date}`.


### FileSystem (**Already Implemented**)
---

In our file system, `FileSystem` class is used to represent the entire structure of the file system. We store file's information in the instance variables corresponding to each of the Hash Map/BST implementations (shown below) to ensure that the look up times are as efficient as possible. You **DO NOT** need to add any code for this sub-section, the logic has already been implemented in the `FileSystem.class` file, this sub-section explains how Hash Map and BST implementations of `DefaultMap` (that you created in part 1) are used to implement our unix based file system.

#### Instance Variables for Hash Map Implementation

##### `nameMap`

A MyHashMap that uses file's name as the key and a list of FileData as the value.

<img src="https://i.imgur.com/S2bucAA.png" width="500">

<!-- ![](https://i.imgur.com/S2bucAA.png) -->
**Illustration to show that "test.txt" is an entry within nameMap that uses filename (String) as a key that maps to an arraylist of all fileData with the same filename but in a different directory.*

##### `dateMap`

A MyHashMap that uses file's date as the key and a list of FileData as the value.

<img src="https://i.imgur.com/DSqDRBz.png" width="500">

<!-- ![](https://i.imgur.com/DSqDRBz.png) -->
**Illustration to show that "02/01/2021" is an entry within nameMap that uses file's lastModifiedDate (String) as a key that maps to an arraylist of all fileData with the same lastModifiedDate.*


#### Instance Variables for BST Implementation

##### `nameTree`

A BST that uses the file name as the key and the `FileData` as the value.  

<img src="https://i.imgur.com/io0Fayy.png" width="500">

<!-- ![](https://i.imgur.com/io0Fayy.png) -->

##### `dateTree`

A BST that uses the file date in a different format (format: yyyy/mm/dd) as the key and a list of FileData as the value. This list should keep track of the files in the order that they arrive in.   

<img src="https://i.imgur.com/hlOvqBl.png" width="500">

<!-- ![](https://i.imgur.com/hlOvqBl.png) -->

##### `dc`

A `DateComparator` that is used to compare the date on the files.

#### Methods
In `FileSystem.class`, the following methods have been implemented (you would need to refer to them for answering the third Gradescope Question; you can refer to their detailed descriptions, for both HashMap and BST implementations, in Appendix):

**Methods implemented for Hash Map implementation**
- `public FileSystem()`
- `public FileSystem(String fileInfo)`
- `public boolean add(String fileName, String directory, String modifiedDate)`
- `public FileData findFile(String name, String directory)`
- `public ArrayList<String> findAllFilesName()`
- `public ArrayList<FileData> findFilesByName(String name)`
- `public ArrayList<FileData> findFilesByName(String modifiedDate)`
- `public ArrayList<FileData> findFilesInMultDir(String modifiedDate)`
- `public boolean removeByName(String name)`
- `public boolean removeFile(String name, String directory)`

**Methods implemented for BST implementation**
- `public FileSystem()`
- `public FileSystem(String inputFile)`
- `public void add(String name, String dir, String date)`
- `public ArrayList<String> findFileNamesByDate(String date)`
- `public FileSystem filter(String startDate, String endDate)`
- `public FileSystem filter(String wildCard)`
- `public List<String> outputNameTree()`
- `public List<String> outputDateTree()`


## Testing (3 points)
---

In the starter code, there are three files where you may add tests:
- MyHashMapTest.java
- BSTTest.java
- FileDataTest.java

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
* FileData.java

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

#### Part 1 & 2

On the Gradescope assignment: **PA5-code** please submit the following files:

* MyHashMap.java
* MyHashMapTest.java
* BST.java
* BSTTest.java
* FileData.java
* FileDataTest.java

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

#### Part 3

Please submit your answers to the questions from part 3 on the Gradescope assignment: **PA5-written**. You may submit as many times as you like till the deadline.


## Scoring (60 points total)

- 18 points: HashMap implementation of `DefaultMap` [automatically graded]
- 18 points: BST implementation of `DefaultMap` [automatically graded]
- 8 points: implementation of `FileData` [automatically graded]
- 3 point: MyHashMapTest, BSTTest, and FileDataTest graded on completion [manually graded]
- 9 points: Gradescope Questions [manually graded]
- 4 points: Style [manually graded]

There is no bad implementation testing on this PA. However, we highly recommend you use the practices you know from testing to thoroughly check that `MyHashMap` and the `BST` you wrote work as expected.

