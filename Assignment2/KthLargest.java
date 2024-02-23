package Assignment2;

import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        // My approach would be involving a min heap
        // For an array of size n, we add elements to the heap until they exceed k total elements
        // When the number of elements exceeds k, we get rid of the smallest (the root)
        // By the end, kth largest value would be at the root of the min heap
        // time complexity is O(n log k)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.add(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        KthLargest test = new KthLargest();

        int ans = test.findKthLargest(nums,k);
        System.out.println("k = " + k + ", Largest: " + ans);

        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        k = 4;
        ans = test.findKthLargest(nums2, 4);
        System.out.println("k = " + k + ", Largest: " + ans);

    }
}
