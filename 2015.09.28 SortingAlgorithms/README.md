#Sorting Algorithms

##WHAT I LEARNED
There are many  different sorting algorithms and if I include variations of each there would never be any way to implement them all. Some work well on only certain data (such as BublleSort which is only super fast on an almost sorted list or a list when all of the small elements are toward the front), whereas others work well most of the time but excel at nothing. 

##IMPLEMENTATION
I chose to have a Sorter interface that delegated a sort method to all of the types of sort[ing algortithm]. I then created Concrete Sorting Algorithm classes that did all of the sorting in their sort and helper methods. Furhter, I used the Singleton pattern because there is never really any need to have more than one Sorter object of any specific concrete class, especially since it stores no data in the objecct.
Because of this, I am not sure that it is the best way to have implemented the project. Perhaps I shouldn't have made a new class for each type of sort, but I cannot really say what the baest way to do things is.

###BubbleSort
This sorting technique is pretty naive if you ask me. Basically, you pass through the array n times, taking the next largest element that you find to its correct position by swapping for a larger element any time that you find one. This means that most of the time this algorithm takes O(n^2) time which is kind of terrible. A good thing about the algorithm is that it can be done in place so no auxillary space is needed.

###MergeSort
This alggorithm breaks recursively breaks the array down into subarrays until they are arrays of size 1 and then at each level merges them back together, sorting them along the way. It is pretty nifty. 
At first, I naively implemented this by creating a working array at every level of recursion, meaning that I had used O(n^2) auxillary space. I realized I could do better and instead opted to pass a work array through the recursion and this took O(n) space, which was a good improvemnt. Also, I am pretty interested in the idea of a Natural Merge Sort, which I might implement in the future.

###QuickSort
This algorithm chooses a pivot and 'partitions' the array in such a way that elements less than the pivot are to the left of the pivot and elements that are larger are placed to the right. Each partition is then recursively sorted in the same way. I actually ran into a bug that I couldn't solve for a while when implenting this - when i had multiple occurences of the same number at certain positions in the array, the algorithm stopped working. I realized that this is due to the fact that once it comes to numbers of the same magnitude, the algorithm thinks that partitioning is done. I added a check for this edge case and everything was seemingly okay after this - more testing may be needed though.


##OTHER DETAILS
I added test cases for each of the sorting methods, but they are not super extensive. I was merely trying to foray into being better at writing tests and familiarizing myself with JUnit. In the future I will probably add more test cases and more sorting algortihms, especially if I become interested in a certain sorting technique or have to implement one for class or something and I want practice first. To start, I basically just chose the three most popular (or widely known at least) sorting algorithms. I would say that working on this project really helped solidify my understanding of these sorting techniques and how to implement them if I am ever asked.