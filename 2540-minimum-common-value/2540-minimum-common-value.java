class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int first =0;
        int second = 0;
        while(first < nums1.length && second < nums2.length) {
            if(nums1[first] < nums2[second]) {
                first++;
            }else if(nums1[first] > nums2[second]) {
                second++;
            }else {
                return nums1[first];
            }
        }
        return -1;
    }
}