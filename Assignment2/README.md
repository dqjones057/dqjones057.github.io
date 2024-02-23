Kth Largest:

My approach would be involving a min heap
For an array of size n, we add elements to the heap until they exceed k total elements
When the number of elements exceeds k, we get rid of the smallest (the root)
By the end, kth largest value would be at the root of the min heap
time complexity is O(n log k).

Majority Element: 

To solve this problem in linear time, I decided to use a loop to iterate through the array. Within the loop I used a hash table to keep track of the count. The O(1) lookup of the hash table made it possible to solve this problem in O(n) time. 

Maximum Gap: 

The maximum gap problem was difficult to solve in O(n) time and space but by using buckets to group the elements I was able to solve it
Shortest Subarray with Sum == k: 