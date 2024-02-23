package Assignment2;

import java.util.Arrays;

class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        // Find max and min
        int max = nums[0], min = nums[0];
        int n = nums.length;

        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min,num);
        }

        // determine bucket size, our max gap will be no smaller than this
        int bucketSize = (int) Math.ceil((double)(max-min)/(n-1));

        // setup n-1 total buckets, these arrays will store the max and min values for each
        int[] bucketMin = new int[n];
        int[] bucketMax = new int[n];

// Placeholder values so we can ensure that garbage values don't interfer with finding mins and maxes
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for(int element : nums){
            // This index represents which bucket within range (min,max)
            // Dividing by bucketSize tells us how many buckets away from bucket 0 (where min is)
            // the current element is
            int index = (element - min)/bucketSize;

            bucketMin[index] = Math.min(element, bucketMin[index]); // gets rid of placeholder
            bucketMax[index] = Math.max(element,bucketMax[index]);
            // both arrays should be filled with the same values currently
        }
        // Next we find the maximum gap
        // We move through the buckets calculating the difference between current bucket's min and
        // and the previous bucket's max until the maximum difference aka max gap is found
        int maximumGap = bucketSize; // remember it has to be at least >= to bucketSize
        int prevMax = bucketMax[0]; // start with first max, subtract this from current bcket's min
        for(int i = 1; i < n ; i++){
            if(bucketMin[i] == Integer.MAX_VALUE){
                continue; // in this case bucket is empty so skip it
            }
            maximumGap = Math.max(maximumGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i]; // move up to next bucket before doing next comp
        }
        return maximumGap;

    }

    public static void main(String[] args) {
        MaximumGap test = new MaximumGap();
        int[] nums = {3, 6, 9, 1};
        int maxGap = test.maximumGap(nums);
        System.out.println("Maximum Gap: " + maxGap);

        int[] nums2 = {10};
        maxGap = test.maximumGap(nums2);
        System.out.println("Maximum Gap: " + maxGap);
    }
}


