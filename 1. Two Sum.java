/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> mapping = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(mapping.containsKey(complement)) {
                res[0] = mapping.get(complement);
                res[1] = i;
                return res;
            }
            mapping.put(nums[i], i);
        }
        return res;
    }
}


//can't assume it's sorted. it is not
