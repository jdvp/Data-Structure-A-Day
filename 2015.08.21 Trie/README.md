#Tries

##WHAT I LEARNED
I learned that a trie (from reTRIEval) is an ordered tree structure that organizes data using prefixes. The keys are usually strings since a lot of the use for these deals with text. However, I assume you could use other data types as keys. For instance, you could create a trie where the children were 0 or 1 and store binary data along the paths. In a trie with String keys, the root node has no prefix(or if it did it would be ""). Each trie node has children that correspond to letters in a word that has up until this point as a prefix (e.g. a node at path root->P->A->T might have a child H since PATH is a word). Each node can also have a value associated with it depending on whether or not the prefix has any meaning in relation to what the trie is being built for (in my PATH example, the node at root->P->A->T->H might have a definiton of the word path).

Tries seem to be pretty cool. But I'm more interested in learning about Suffix Trees which can help carry out full text querying.

##WHAT I IMPLEMENTED
I decided to implement a dictionary lookup program. I used a JFrame to get user input. As a user types into the search bar, the search results update in real time. I created a Trie type that has a value (which is the dictionary entry) and children. Each trie node has 26 children nodes in a Trie[] structure. At first I was using an ArrayList of Tries but I didn't like the fact that I was having to search the ArrayList for the index of the Trie I wanted and then retrieve it (since ArrayLists don't have to be ordered in any particular way). 
Since I chose such a rigid design, it is infeasible to search for words that have special characters (e.g. sand-box) or anything that has numbers in it.  The order of the 26 children determines the letter being added to the prefix. Having 26 children per node doesn't significantly increase space (as opposed to using an ArrayList) since unless they are initialized, each child points to null.

##CHALLENGES
The biggest challenge that I had for this project was figuring out how to traverse the tree such that I could print the results of everything after the given prefix in order. At first, I had to search an ArrayList for each ascending character from a to z and then call on the children list to get the specific trie and call to print its children. However, when I made the switch to having an array of Tries, this became much simpler.
Building the GUI was probably the easiest part since I just borrowed a GUI from a project I had done previously : [MassPDFSearch](https://github.com/jdvp/MassPDFSearch).