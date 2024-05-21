public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int first = 0;
        int second = 0;

        // Traverse through both arrays with two pointers
        // Increment the pointer with a smaller value at that index
        // Return the first common element found
        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] < nums2[second]) {
                first++;
            } else if (nums1[first] > nums2[second]) {
                second++;
            } else {
                return nums1[first];
            }
        }

        // Return -1 if there are no common elements
        return -1;
    }
}