Arrays

WHAT I LEARNED
An array is a data structure that holds information and indexes said information. For instance, I can have an array that contains the letters of the alphabet. At the fifth index (or fourth if we are indexing from 0), I would find the letter 'e'. 
This relates single-dimensional arrays to lists, since lists can be built from arrays. Further, matrices can be stored using n-dimensional arrays. When using an n-dimensional array, you can find the value of a specific element by using a tuple with n components. If I was looking at a 2D Array and wanted the element in the second row and second column, I could use the tuple (2, 2) as a lookup (this depends on the language though, so in Java I might do array[1][1]). 

Arrays are one of the msot important data structures since many other structures use arrays for implementation. This includes the aforementioned lists and arrays but also heaps and strings (which are an array of characters). 


WHAT I IMPLEMENTED
I created a program for doing matrix operations. Currently, it has three operations: addition, subtraction, and multiplication. However, it is easily-extensible since I used an Abstract class to extend when creating matrix operations concrete classes. I chose this project because it required me to use a lot of arrays and also allows users to do operations on arrays. I chose to use primitive arrays as opposed to ArrayLists because I wouldn't understand the inner workings of an array if I used a container. 

The program allows users to choose their array operation, enter the size of the matrices to use, and then enter the matrices to use in the operation. The program then calculates the result and relays this to the user. The user can then choose to use the result in another computation or start from scratch. Typing 'exit' at any time will exit the program.

CHAllENGES
There were hardly any challenges actually using the arrays, except for sometimes I forgot to make sure that a loop stopped at the correct index (ArrayIndexOutOfBoundsExceptions). The bigger problem that I had was simply getting the matrices to print out in a nice fashion. It probably took up the majority of time spent on this project and is where I ran into the most errors (for some reason I did the padding incorrectly at first and got tons of index out of bounds errors later on). 
Another smaller problem was that matrix multiplication didn't work for some time until I realized that I was stopping one index too early.