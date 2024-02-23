package Assignment2;

import java.util.HashMap;
import java.util.Map;

class MajorityElement {
    public int majorityElement(int[] nums) {
        // Thought process: Use a hash table where each key-value pair is an element paired with its count

        int size = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>(); // <element,count>

        for(int num : nums){
            int count = 0;
            if(hashMap.containsKey(num)){
                // gets the current count associated with element, then increments
                hashMap.put(num, hashMap.get(num) + 1);

                if(hashMap.get(num) > size/2){
                    return num;
                }
            }else{
                // If the map does not yet contain this element, add it now
                hashMap.put(num, ++count);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();
        int[] nums = {3,2,3};
        int ans = test.majorityElement(nums);
        System.out.println("Majority Element: " + ans);

        int[] nums2 = {2,2,1,1,1,2,2};
        ans = test.majorityElement(nums2);
        System.out.println("Majority Element: " + ans);
    }
}