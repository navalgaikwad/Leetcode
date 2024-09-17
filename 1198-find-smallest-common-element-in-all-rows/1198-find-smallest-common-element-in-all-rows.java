class Solution {
    public int smallestCommonElement(int[][] mat) {
        int count =0;
        for(int i=0; i<mat[0].length; i++) {
            int val = mat[0][i];
            count = 0;
            for(int j=1; j< mat.length; j++) {
                if(!binarySearch(mat[j], val)) {
                    break;
                }
                count++;
            }
            if(count == mat.length - 1) {
                return val;
            }
        }
        return -1;
    }
    
    boolean binarySearch(int[] mat, int target) {
        int left =0;
        int right =mat.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(mat[mid] == target) {
                return true;
            }
            if(target < mat[mid] ) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}