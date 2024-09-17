class Solution {
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int count = 0;
        for (int j = 0 ; j < n ; j++) {
            int val = mat[0][j];
            count = 0;
            for (int i = 1; i < m; i++) {
                if (!check(val, mat[i])) 
                    break;
                count+=1;
            }
            if (count == m-1)
                return val;
        }
        return -1;
    }

    private boolean check(int val, int[] arr) {
        int l = 0, r = arr.length, mid = 0;
        while (l<r) {
            mid = l + (r - l)/2;
            if (val <= arr[mid]) {
                r = mid;
            } else {
                l = mid+1;
            }
        } 
        return l<arr.length && val == arr[l];
    }
}