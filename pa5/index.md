---
layout: pa
title: "PA5: FileSystem"
doodle: "../doodle.png"
---
---
# PA5: FileSystem
---

This assignment will teach you how to use a Hash Map to implement a basic file searching system and how to implement a Binary Search Tree (BST).

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


# Part 1: File System Implementation (16 points)
You are asked to implement a basic unix file system structure to support files look up methods. It is shown in the log history that users tend to search files either by their names, their directories, or their modified dates. You think that a hash map will be a perfect data structure for this task to perform these searches in an efficient way. Your task is to design a simplified file system structure with a hash map that can support users defined filtering methods while making sure that those filtering methods are performed in an efficient way.

You should only modify `FileSystem.java` for implementation of the file system. 

*Note*: It's likely that you need to store multiple files with the same name in your computer, therefore our file system support duplicate files with the same name or date in different directories. However, the name should always be unique in each directory.

## FileData
In our file system, a file is represented as a `FileData` object which contains the information of its name, directory, and last modified date. 
### Instance Variables
#### `name`
The name of the given file in string format.
#### `dir`
The directory of where the file is stored in, represented in a string format.
#### `lastModifiedDate`
The date of when the file is last modified, represented in a string format.


## FileSystem

In our file system, FileSystem class will be used to represent the entire structure of the file system. You should store file's information in the instance variable provided to ensure that the look up times are as efficient as possible.  You are **NOT ALLOWED** to add any additional instance variables or to include any additional imports in `FileSystem.java`.

### Instance Variables
#### `nameMap`
A HashMap that uses file name as the key and a list of FileData as the value.
![](https://i.imgur.com/S2bucAA.png)
**Illustration to show that "test.txt" is an entry within nameMap that uses filename (String) as a key that maps to an arraylist of all fileData with the same filename but in a different directory.*

#### `dateMap`
A HashMap that uses file's date as the key and a list of FileData as the value.
![](https://i.imgur.com/DSqDRBz.png)
**Illustration to show that "02/01/2021" is an entry within nameMap that uses file's lastModifiedDate (String) as a key that maps to an arraylist of all fileData with the same lastModifiedDate.*


### Methods
In `FileSystem.java`, you will implement and thoroughly test the following methods:

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

#### `public FileSystem()`
Default constructor that creates a new `FileSystem` object and initializes its instance variable.

#### `public FileSystem(String inputFile)`

*Constructor* that creates a new `FileSystem` object with the given `inputFile` that contains the file system information. We have provided some skeleton code for reading the contents of the text file. You will need to initailizes FileSystem's instance variables and populate FileSystem with each file's information. Each file information is represented by a line formatted as `filename, directory, date` within the content of `inputFile`. For example, it could be `mySample.txt, /home, 02/01/2021`. (Note that since it is a unix type file system, forward slashes are used to represent directory hierarchy). We have also provided a sample file, `input.txt`, to show how each file information is represented within the inputFile. Feel free to add more data to the file to test your FileSystem implementation thoroughly. You may assume that `inputFile` parameter is properly formatted and is non-null.


#### `public boolean add(String fileName, String directory, String modifiedDate)`

This method should create a FileData object with the given file information and add it to the instance variables of FileSystem. This method should return true if the file is successfully added to the FileSystem, and false if a file with the same name already exists in that directory. The default values for `filenName`, `dir`, and `modifiedDate` are `""`, `"/"`, `"01/01/2021"` in case any of these variables is null.


#### `public FileData findFile(String name, String directory)`
This method should return a single FileData object with the given name and directory. You should not modify the FileSystem itself. Return null if such a file does not exist. 

#### `public ArrayList<String> findAllFilesName()`

This method should return an array list of string that represents all unique file names across all directories within the FileSystem. You should not modify the FileSystem itself. Return an empty array list if there is no file in the file system yet.

#### `public ArrayList<FileData> findFilesByName(String name)`

The find method should return a list of FileData with the given name. You should not modify the FileSystem itself. Return an empty list if such a file does not exist. 

#### `public ArrayList<FileData> findFilesByDate(String modifiedDate)`
This find method should return a list of FileData with the given modifiedDate. You should not modify the FileSystem itself. Return an empty list if such a file does not exist. 

#### `public ArrayList<FileData> findFilesInMultDir(String modifiedDate)`
This find method should return a list of FileData with the given modifiedDate that has at least another file with the same file name in a different directory. You should not modify the FileSystem itself. Return an empty list if such a file does not exist. 

#### `public boolean removeByName(String name)`
This method should remove all the files with the given name in the FileSystem. Return true if success, false otherwise. Remove the entry in the hashmap if necessary.

#### `public boolean removeFile(String name, String directory)`

This method should remove a certain file with the given name and directory. Return true if success, false otherwise. Remove the entry in the hashmap if necessary.




# Part 2: An Implementation of `DefaultMap` as a BST (18 points)

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


# Part 3: Gradescope Assignment (9 points)

Respond to the following prompts in *pa5-written*:

1. Describe what the best case would be for a non-empty BST, specifically, what does the tree look like? How is this the best case? What methods benefit from the best case scenario? 
2. Justify the runtime bounds (worst case) for the methods you wrote in `BST`.


# Testing (3 points)
In the starter code, there are three files where you may add tests:
- FileSystem.java
- BSTTest.java

For this PA, your unit tests will be graded for completion only, however, we **strongly** encourage you to thoroughly test every public method in your class (helper methods you create should inherently be *private*). You are required to have at least **two unique unit tests for each method** written by yourself. 

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

# Style (4 points)
The following files will be graded on style:
* FileSystem.java
* BST.java
* BSTTest.java

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


# Submitting

## Part 1, 2 
On the Gradescope assignment **PA5-code** please submit the following files:

* FileSystem.java
* FileSystem.java
* BST.java
* BSTTest.java

## Part 3
On the Gradescope assignment **PA5-written** please submit the following files

# Scoring (52 points total)

- 16 points: implemetnation of `FileSystem` [automatically graded]
- 3 point: FileSystem graded on completition [manually graded]
- 18 points: implementation of `DefaultMap` as `BST.java`[automatically graded]
- 2 point: BSTTest graded on completition [manually graded]
- 9 points: Gradescope Questions [manually graded]
- 4 points: Style [manually graded]

There is no bad implementation testing on this PA. However, we highly recommend you use the practices you know from testing to thoroughly check that everything you wrote works as expected.






