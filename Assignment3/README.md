**Sorted List to BST:** 

My approach to this problem consisted of finding the middle element so that I could find the root of the tree. To accomplish this I used fast and slow pointers to traverse the entire list giving us so far O(n) time complexity. After finding the middle element, I used recursion to do the same for each child, cutting n by half each time I make a recursive call. I believe this gives a total time complexity of O(n log(n)). 

**BST from preoder and inorder traversal:** 

My approach to this problem was to find the root in the preorder array and use it to split the inorder array into two subarrays representing the values of the left subtree and the right subtree.I repeated this process for every value in preorder until the entire tree was constructed. It takes O(n) time to store the inorder values/indexes into the hash table for quick access and it also takes O(n) time to construct each node of the tree. Thus is a total time complexity of O(n+n) = O(2n) =O(n). 

**Largest Value in each Tree Row:** 

My approach to this problem was to use BFS to check every node at each level of the tree, keeping track of the current max and storing it in an arraylist when the max is confirmed. As it took me looking through each node at each level, the time complexity is simply O(n). 

**Maximum Path Sum**
For this problem my approach was to use DFS to determine the appropriate path to take for the max path sum. At each node, the algorithm compares the paths of each child to determine which will provide the max sum. Nodes with negative path sums are ignored as we want to maximize the sum.  During the traversal each node is visited only once so that gives us a time complexity of O(n). 

**Balance a BST:**
My approach to this problem was to follow the hints and first conduct an inorder traversal of the tree so that I can store the values in a sorted array. From there my approach was similar to the previous problem of constructing a tree from preorder and inorder arrays. We split the sorted array into subarrays that represent the values of each subtree and recursively build each node. The output may be a tree with a different root, however it will be a balanced tree. We have an O(n) time complexity for the inorder traversal but in addition we must also take into account that we rebuild the tree node by node so we must add another O(n). In total the time complexity simplifies to O(n). 