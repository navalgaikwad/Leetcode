class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int index1 = 0, index2 = 0;
        int index = 0;
        while(index1 < m && index2 < n) {
            if(nums1[index1] <= nums2[index2]) {
                arr[index++] = nums1[index1];
                index1++;
            }
            if(nums2[index2] <= nums1[index1]) {
                arr[index++] =nums2[index2];
                index2++;
            }
        }
        if(index1 < m) {
            while(index1 < m) {
                arr[index++] = nums1[index1++]; 
            }
        }
        if(index2 < n) {
            while(index2 < n) {
                arr[index++] = nums2[index2++]; 
            }
        }
        
        for(int i=0; i<m+n; i++) {
            nums1[i] = arr[i];
        }
    }
    
}