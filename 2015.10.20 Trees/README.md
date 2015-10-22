#Trees

##WHAT I LEARNED
There are many types of Trees (in fact I have implemented Tries before here [here](https://github.com/jdvp/Data-Structure-A-Day/tree/master/2015.08.21%20Trie).) that have many different qualities. (Sorry for the generic answer here, maybe I will elaborate below)
	Binary Search Trees
		These types of trees are composed of nodes that can have between 0 and 2 children. Each node in the trees satisfies the fact that children on the left have values less than the parent node and children on the right have values greater than the parent node
	Binary Trees
		Like a BST but data can basically be anywhere willynilly in the structure unless you choose to sort or structure it somehow
		

##WHAT I IMPLEMENTED
10/20 - 10/21
	I implemented a pretty decent (in my opinion) Binary Search Tree class and an almost completed regular binary tree class. I would have done more but I was pretty focused on making sure the ANode class would be pretty extensible since there are so many kinds of trees and nodes can hold any amount of data. 
	In the future I plan to implement some sort of balancing binary tree (probably AVL trees) and n-ary trees of some sort. I also think it would be cool to make a Function class that I could pass in to a BinarySearchTree object in order to sort the tree in some way other than less than on left and greater than on the right. For instance I could have it so that if an inserted node is over a factor of ten larger it goes on the left otherwise it goes on the right (what would I even use that for? Maybe it's a bad example).

##CHALLENGES
At first, I had a pretty hard time figuring out how to do deletions. I was trying to figure out how delete from the current node without knowing the node's parent but I quickly realized that that would never work out. I had to do a bit of wikipedia-ing (but don't we all?) in order to see how it is generally done, and I finally got an implementation working. 

Another thing was making sure that my tests had good coverage. I'm trying to write more test cases lately (I hear it is good practice and helps make debugging easier if you do it along the way), but sometimes it's ahrd to figure out edge cases. In fact, I'm sure some have slipped by me.