/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
// IMPORTANT

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int cutStart = 0, cutEnd = nums1.length;
        int cut1, cut2, L1, L2, R1, R2;
        while(cutStart <= cutEnd) {
            cut1 = (cutEnd - cutStart) / 2 + cutStart;
            cut2 = (nums1.length + nums2.length) / 2 - cut1;
            L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                cutEnd = cut1;
            } else if (L2 > R1) {
                cutStart = cut1 + 1;
            } else {
                if((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.min(R1, R2);
                }
            }
        }
        return - 1;
    }
}

// O(log (m+n)) means some kind of binary or divide approach
// https://blog.csdn.net/chen_xinjia/article/details/69258706
