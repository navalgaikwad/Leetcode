class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        int i = 0;
        int j = 0;
        while(i<nums1.length && j < nums2.length) {
            if(nums2[j] >= nums1[i]) {
                int diff = j - i;
                max = Math.max(max, diff);
                j++;
            }else {
                i++;
            }
            
        }
        return max;
    }
}