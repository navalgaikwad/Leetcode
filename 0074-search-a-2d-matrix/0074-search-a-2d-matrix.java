class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1; // Calculate the right boundary based on the total number of elements

       return binarySearch(matrix, target, 0, right);
    }
    
    boolean binarySearch(int[][] matrix, int target, int left, int right) {
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / matrix[0].length;//divide my col length
            int col = mid % matrix[0].length;//divide by col length
            
            if( matrix[row][col] == target) {
                return true;
            }
            if(matrix[row][col] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}