---
layout: pa
title: "PA5: Hash Map and BST"
doodle: "../doodle.png"
---

**This assignment is closed to collaboration.**

This assignment will teach you how to implement a Hash Map and a Binary Search Tree and use them to implement a basic file searching system or to order and filter data from a text file. 

## Deadlines

This PA is due on ** **Thursday, July 28, at 11:00pm PST** **  

## Resources

Link to FAQ: https://piazza.com/class/kirvel5rj2337n   
Link to PA Video: https://canvas.ucsd.edu/courses/21784/external_tools/82 


## Getting the Code

The starter code is in the Github repository at  [https://github.com/ucsd-cse12-ss22/PA5_starter_code](https://github.com/ucsd-cse12-ss22/PA5_starter_code). If you are not familiar with Github, here are two easy ways to get your code.

1. Download as a ZIP folder 

   If you scroll to the top of Github repository, you should see a green button that says *Code*. Click on that button. Then click on *Download ZIP*. This should download all the files as a ZIP folder. You can then unzip/extract the zip bundle and move it to wherever you would like to work. The code that you will be changing is in the folder called *pa5-starter*.

2. Using git clone (requires terminal/command line)

   If you scroll to the top of the Github repository, you should see a green button that says *Code*. Click on that button. You should see something that says *Clone with HTTPS*. Copy the link that is in that section. In terminal/command line, navigate to whatever folder/directory you would like to work. Type the command `git clone _` where the `_` is replaced with the link you copied. This should clone the repository on your computer and you can then edit the files on whatever IDE you see fit.

If you are unsure or have questions about how to get the starter code, feel free to make a Piazza post or ask a tutor for help.

## Part 1: Hash Map and Binary Search Tree Implementations of `DefaultMap` (18 points)

## Hash Map Implementaion

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
 
### `HashMapEntry<K, V>`
Within `MyHashMap.java`, you are provided the private inner class `HashMapEntry<K, V>`. Use this class to represent your key value pairs in your HashMap. Note it implements the `DefaultMap.Entry<K, V>` interface. Each `HashMapEntry` object has two instance variables (`K key`, `V value`). Use the getters/setters from this class to get the key values and set the values. 

### Instance Variables
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


## Binary Search Tree Implementation

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
