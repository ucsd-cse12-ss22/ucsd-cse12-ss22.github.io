---
layout: pa
title: "PA5: FileSystem"
doodle: "../doodle.png"
---
---
# PA5: FileSystem
---

This assignment will teach you how to use Hash Maps and Binary Search Trees (BSTs) and apply them to implement two basic file searching systems.

This PA is due on ** **Thursday, January 28th at 11:00pm** **  


## CSE Mantra: *Start early, start often!*

*You will notice throughout the quarter that the PAs get harder and harder. By starting the quarter off with good habits, you can prepare yourself for future PAs that might take more time than the earlier ones.*

## Getting the Code
The starter code is in the Github repository that you are currently looking at. If you are not familiar with Github, here are two easy ways to get your code.

1. Download as a ZIP folder 

    If you scroll to the top of Github repository, you should see a green button that says *Code*. Click on that button. Then click on *Download ZIP*. This should download all the files as a ZIP folder. You can then unzip/extract the zip bundle and move it to wherever you would like to work. The code that you will be changing is in the folder called *pa5-starter*.

2. Using git clone (requires terminal/command line)

    If you scroll to the top of the Github repository, you should see a green button that says *Code*. Click on that button. You should see something that says *Clone with HTTPS*. Copy the link that is in that section. In terminal/command line, navigate to whatever folder/directory you would like to work. Type the command `git clone _` where the `_` is replaced with the link you copied. This should clone the repository on your computer and you can then edit the files on whatever IDE you see fit.
    
If you are unsure or have questions about how to get the starter code, feel free to make a Piazza post or ask a tutor for help.


## Part 1: HashMap File System Implementation (16 points)
You are asked to implement a basic unix file system structure to support files look up methods. It is shown in the log history that users tend to search files either by their names, their directories, or their modified dates. You think that a hash map will be a perfect data structure for this task to perform these searches in an efficient way. Your task is to design a simplified file system structure with a hash map that can support users defined filtering methods while making sure that those filtering methods are performed in an efficient way.

You should only modify `HashMapFileSystem.java` for implementation of the file system. 

*Note*: It's likely that you need to store multiple files with the same name in your computer, therefore our file system support duplicate files with the same name or date in different directories. However, the name should always be unique in each directory.

### FileData
In our file system, a file is represented as a `FileData` object which contains the information of its name, directory, and last modified date. 
#### Instance Variables
##### `name`
The name of the given file in string format.
##### `dir`
The directory of where the file is stored in, represented in a string format.
##### `lastModifiedDate`
The date of when the file is last modified, represented in a string format.


### HashMapFileSystem

In our file system, HashMapFileSystem class will be used to represent the entire structure of the file system. You should store file's information in the instance variable provided to ensure that the look up times are as efficient as possible.  You are **NOT ALLOWED** to add any additional instance variables or to include any additional imports in `HashMapFileSystem.java`.

#### Instance Variables
##### `nameMap`
A HashMap that uses file name as the key and a list of FileData as the value.
![](https://i.imgur.com/S2bucAA.png)
**Illustration to show that "test.txt" is an entry within nameMap that uses filename (String) as a key that maps to an arraylist of all fileData with the same filename but in a different directory.*

##### `dateMap`
A HashMap that uses file's date as the key and a list of FileData as the value.
![](https://i.imgur.com/DSqDRBz.png)
**Illustration to show that "02/01/2021" is an entry within nameMap that uses file's lastModifiedDate (String) as a key that maps to an arraylist of all fileData with the same lastModifiedDate.*


#### Methods
In `HashMapFileSystem.java`, you will implement and thoroughly test the following methods:

- `public HashMapFileSystem()`
- `public HashMapFileSystem(String fileInfo)`
- `public boolean add(String fileName, String directory, String modifiedDate)`
- `public FileData findFile(String name, String directory)`
- `public ArrayList<String> findAllFilesName()`
- `public ArrayList<FileData> findFilesByName(String name)`
- `public ArrayList<FileData> findFilesByName(String modifiedDate)`
- `public ArrayList<FileData> findFilesInMultDir(String modifiedDate)`
- `public boolean removeByName(String name)`
- `public boolean removeFile(String name, String directory)`

#### `public HashMapFileSystem()`
Default constructor that creates a new `HashMapFileSystem` object and initializes its instance variable.

#### `public HashMapFileSystem(String inputFile)`

*Constructor* that creates a new `HashMapFileSystem` object with the given `inputFile` that contains the file system information. We have provided some skeleton code for reading the contents of the text file. You will need to initailizes HashMapFileSystem's instance variables and populate HashMapFileSystem with each file's information. Each file information is represented by a line formatted as `filename, directory, date` within the content of `inputFile`. For example, it could be `mySample.txt, /home, 02/01/2021`. (Note that since it is a unix type file system, forward slashes are used to represent directory hierarchy). We have also provided a sample file, `input.txt`, to show how each file information is represented within the inputFile. Feel free to add more data to the file to test your HashMapFileSystem implementation thoroughly. You may assume that `inputFile` parameter is properly formatted and is non-null.


#### `public boolean add(String fileName, String directory, String modifiedDate)`

This method should create a FileData object with the given file information and add it to the instance variables of HashMapFileSystem. This method should return true if the file is successfully added to the HashMapFileSystem, and false if a file with the same name already exists in that directory. The default values for `filenName`, `dir`, and `modifiedDate` are `""`, `"/"`, `"01/01/2021"` in case any of these variables is null.


#### `public FileData findFile(String name, String directory)`
This method should return a single FileData object with the given name and directory. You should not modify the HashMapFileSystem itself. Return null if such a file does not exist. 

#### `public ArrayList<String> findAllFilesName()`

This method should return an array list of string that represents all unique file names across all directories within the HashMapFileSystem. You should not modify the HashMapFileSystem itself. Return an empty array list if there is no file in the file system yet.

#### `public ArrayList<FileData> findFilesByName(String name)`

The find method should return a list of FileData with the given name. You should not modify the HashMapFileSystem itself. Return an empty list if such a file does not exist. 

#### `public ArrayList<FileData> findFilesByDate(String modifiedDate)`
This find method should return a list of FileData with the given modifiedDate. You should not modify the HashMapFileSystem itself. Return an empty list if such a file does not exist. 

#### `public ArrayList<FileData> findFilesInMultDir(String modifiedDate)`
This find method should return a list of FileData with the given modifiedDate that has at least another file with the same file name in a different directory. You should not modify the HashMapFileSystem itself. Return an empty list if such a file does not exist. 

#### `public boolean removeByName(String name)`
This method should remove all the files with the given name in the HashMapFileSystem. Return true if success, false otherwise. Remove the entry in the hashmap if necessary.

#### `public boolean removeFile(String name, String directory)`

This method should remove a certain file with the given name and directory. Return true if success, false otherwise. Remove the entry in the hashmap if necessary.




## Part 2: An Implementation of `DefaultMap` (18 points)

You’ll provide a fast implementation of an interface called `DefaultMap` in `BST.java`.  


You will implement all the methods defined in the `DefaultMap` interface. You must ensure that each has the specified big-O bound in the **worst case**, and argue why based on the documentation of any libraries you use, or based on your implementation. Note that these are big-O bounds, so doing _better_ (like O(1) where O(log(n)) is required) is acceptable. In each, _n_ represents the number of entries in the map.

- `put`, required O(n)
- `replace`, required _O(n)_
- `remove`, required _O(n)_
- `set`, required _O(n)_
- `get`, required _O(n)_
- `size`, required _O(1)_
- `isEmpty`, required _O(1)_
- `containsKey`, required _O(n)_
- `keys`, required _O(n)_

In `BST`, you will need come up with the proper instance variables to achieve the above runtime requirements.

The specifications for the other methods are defined in header comments in the `DefaultMap.java` file, which you should follow. 

**Important:** for keys(), the returned result need to be in ascending order

***Note:*** You are not allowed to use the java `SortedMap` interface or `Collections.sort`, or any other implementations of BSTs or sorting!!!

Your implementation of `DefaultMap` will be graded automatically by tests that we provide. We’ll provide a very minimal sanity check in the grader. DO NOT rely on it for testing!

## Part 3: File System Filtering (16 points)

 <hr />

### FileData 

 <hr />

In our file system, a file is represented as a `FileData` object which contains the information of its name, directory, and last modified date. This is the same FileData from above.


### BSTFileSystem

 <hr />

The BSTFileSystem class will be used to represent the entire structure of the file system. You should store the file information in the instance variables provided to ensure that the lookup times are as efficient as possible.  You are **NOT ALLOWED** to add any additional instance variables or include any additional imports in `BSTFileSystem.java`.

## Instance Variables

##### `nameTree`

A BST that uses the file name as the key and the `FileData` as the value.  

![](https://i.imgur.com/io0Fayy.png)




##### `dateTree`

A BST that uses the file date in a different format (format: yyyy/mm/dd) as the key and a list of FileData as the value. This list should keep track of the files in the order that they arrive in.   

![](https://i.imgur.com/hlOvqBl.png)





##### `dc`

A `DateComparator` that will be used to compare the date on the files (See section below).

## Inner Class `DateComparator`  

At times, we may want to create custom ways to compare two objects. 
To support this, Java has a built-in interface called Comparator that expresses this idea of user-defined comparisons. An implementatation of Comparator provides a single method, called compare, that takes two elements of a particular type and returns a negative number if the first is “smaller” than the second, 0 if they are equal, and a positive number if the first is “larger” than the second.

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

#### `compare` Method

`public int compare(String date1, String date2)`  
Given two strings that contain the last modifed date, if `date1` is more recent than `date2` return 1, if `date1` is less recent than `date2` return -1 and if `date1` is equal to `date2` return 0. For example, `01/01/2021` is less recent than `01/02/2021` - thus `compare("01/01/2021", "01/02/2021")` should return -1. Similarly, `12/01/2020` is less recent than `01/01/2021` and should return -1. You can assume that none of the inputs are null.

Hint: You might want to change the format of the dates   

Additionally, please note that `Comparator` and `Comparable` are **not** the same thing. If you are curious, here are the links to the Java docs: 

Comparator: https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html 
Comparable: https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html

## BSTFileSystem Methods

In `BSTFileSystem.java`, you will implement and thoroughly test the following methods:

- `public BSTFileSystem()`
- `public BSTFileSystem(String inputFile)`
- `public void add(String name, String dir, String date)`
- `public ArrayList<String> findFileNamesByDate(String date)`
- `public BSTFileSystem filter(String startDate, String endDate)`
- `public BSTFileSystem filter(String wildCard)`
- `public List<String> outputNameTree()`
- `public List<String> outputDateTree()`


#### `public BSTFileSystem()`

Default constructor that creates a new `BSTFileSystem` object and initializes its instance variable.

#### `public BSTFileSystem(String inputFile)`

*Constructor* that creates a new `BSTFileSystem` object with the given `inputFile` that contains the file system information. We have provided some skeleton code for reading the contents of the text file. You will need to initailizes BSTFileSystem's instance variables and populate BSTFileSystem with each file's information.   
Each file information is represented by a line formatted as `filename, directory, date` within the content of `inputFile`. For example, it could be `mySample.txt, /home, 02/01/2021`. (Note that since it is a unix type file system, forward slashes are used to represent directory hierarchy).  
We have also provided a sample file, `input.txt`, to show how each file information is represented within the inputFile. Feel free to add more data to the file to test your FileSystem implementation thoroughly.   
You may assume that `inputFile` parameter is properly formatted and is non-null.


#### `public void add(String name, String dir, String date)`

This method should create a FileData object with the given file information and add it to the instance variables of BSTFileSystem. If there is a duplicate file name, then the FileData with the most recent date should be used. For example, if the first FileData stored in the trees is `test.txt, /home, 01/01/2021` and the next FileData is `test.txt, /home, 01/02/2021`, the second FileData should *replace* the first FileData stored in the trees.   
If the `name`, `dir`, or `date` is `null`, then do not add anything to the BSTFileSystem.

#### `public ArrayList<String> findFileNamesByDate(String date)`

Given a `date` (format: mm/dd/yyyy), return an ArrayList of file names that correspond to this date. This list should have the file names in the order that they were added.


If the `date` given is `null`, return `null`.

#### `public BSTFileSystem filter(String startDate, String endDate)`

Given a `startDate` and an `endDate` (format: mm/dd/yyyy), return a new BSTFileSystem that contains only the files that are within the range (`startDate` is inclusive, `endDate` is exclusive).
Assume the given parameters are valid and non-null.  

Example: Let's call `filter("01/20/2021", "02/02/2021")` on a `BSTFileSystem` with the following `dateTree`:   

![](https://i.imgur.com/dlQBJfT.png)




It should return a **BSTFileSystem** with a `dateTree` that looks like the following (note: there should be a populated `nameTree` with the same entries):   

![](https://i.imgur.com/jDzGOt0.png)



#### `public BSTFileSystem filter(String wildCard)`

Give a string `wildCard`, return a new BSTFileSystem that contains only the files with names that contain the `wildCard` string. Note that this wildcard can be found anywhere in the file name (if the wild card is `test`, then `test.txt`, `thistest.txt` and `thistest` would all be files that should be selected in the filter)  
Assume the given parameter is valid and non-null. 

Example: Let's call `filter("mySam")` on a `BSTFileSystem` with the following `nameTree`:  

![](https://i.imgur.com/YBsdlMK.png)  



It should return a **BSTFileSystem** with a `nameTree` that looks like the following (note: there should be a populated `dateTree` as well - it is not shown here):   

![](https://i.imgur.com/MuJ6PM0.png)

#### `public List<String> outputNameTree()`

Return a List<String> that contains the `nameTree` where each entry is formatted as:    
"<file name>: <FileData toString()>"  

This list should be in alphabetical order.   

Input file: 

```
mySample.txt, /home, 02/01/2021
mySample1.txt, /root, 02/01/2021
mySample2.txt, /user, 02/06/2021
```

Example Output: 

```
["mySample.txt: {Name: mySample.txt, Directory: /home, Modified Date: 02/01/2021}", 
"mySample1.txt: {Name: mySample1.txt, Directory: /root, Modified Date: 02/01/2021}", 
"mySample2.txt: {Name: mySample2.txt, Directory: /user, Modified Date: 02/06/2021}"]

```

#### `public List<String> outputDateTree()`

Return a List<String> that contains the `dateTree` where each entry is formatted as:  
"<date>: <FileData toString()>"  

The List should be in order from most recent to oldest. If there are multiple files associated with the same date, add them to the List in reverse order they were added into the ArrayList (see example below).

Input file: 

```
mySample.txt, /home, 02/01/2021
mySample1.txt, /root, 02/01/2021
mySample2.txt, /user, 02/06/2021
```

Example Output:

```
["02/06/2021: {Name: mySample2.txt, Directory: /user, Modified Date: 02/06/2021}", 
"02/01/2021: {Name: mySample1.txt, Directory: /root, Modified Date: 02/01/2021}", 
"02/01/2021: {Name: mySample.txt, Directory: /home, Modified Date: 02/01/2021}"]
```

 <hr />

## Part 4: Gradescope Assignment (9 points)

Respond to the following prompts in *pa5-written*:

1. What is the benefit of returning a `BSTFileSystem` for the filter methods vs a List of the files that meet the filter requirements?
2. Describe what the best case would be for a non-empty BST, specifically, what does the tree look like? How is this the best case? What methods benefit from the best case scenario? 
4. Justify the runtime bounds (worst case) for the methods you wrote in `BST`.


## Testing (3 points)
In the starter code, there are three files where you may add tests:
- HashMapFileSystemTest.java
- BSTTest.java
- BSTFileSystemTest.java

For this PA, your unit tests will be graded for completion only, however, we **strongly** encourage you to thoroughly test every public method in your class (helper methods you create should inherently be *private*). You are required to have at least **two unique unit tests for each method** written by yourself. 

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

### Style (5 points)
The following files will be graded on style:
* HashMapFileSystem.java
* BST.java
* BSTTest.java
* BSTFileSystem.java
* BSTFileSystemTest.java

All guidelines that we will be following this quarter are marked in the Style Guidelines document. These are required and will be graded. 

On this PA, **all guidelines must be followed**, they are summarized below: 

- file headers
- method headers (not required for test methods)
- Inconsistent indentation
- Lines **must not** be indented more than 6 times. If you have a need to
  indent more than 6 levels, build a helper method or otherwise reorganize your code
- Test method must have meaningful names
- Helper method must have meaningful names
- descriptive variable names
- no magic numbers


## Submitting

#### Part 1, 2 & 3
On the Gradescope assignment **PA5-code** please submit the following files:

* HashMapFileSystem.java
* HashMapFileSystemTest.java
* BST.java
* BSTTest.java
* BSTFileSystem.java
* BSTFileSystemTest.java

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

#### Part 4
On the Gradescope assignment **PA5-written** please submit the following files

## Scoring (50 points total)

- 16 points: implemetnation of `HashMapFileSystem` [automatically graded]
- 3 point: HashMapFileSystemTest graded on completition [manually graded]
- 18 points: implementation of `DefaultMap` as `BST.java`[automatically graded]
- 16 points: implementation of `BSTFileSystem` [automatically graded]
- 2 point: BSTTest and BSTFileSystemTest graded on completition [manually graded]
- 9 points: Gradescope Questions [manually graded]
- 5 points: Style [manually graded]

There is no bad implementation testing on this PA. However, we highly recommend you use the practices you know from testing to thoroughly check that everything you wrote works as expected.






