class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int left = 0; int right = matrix[0].length - 1; int top = 0; int bottom = matrix.length - 1;
        while(left <= right && top <= bottom) {
            for(int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]); 
            }
            right--;
            if(top <= bottom) {
                for(int i = right; i>=left; i--) {
                   result.add(matrix[bottom][i]);  
                }
                bottom--;
            }
            if(left <= right) {
               for(int i = bottom; i>=top; i--) {
                   result.add(matrix[i][left]);  
                }
                left++; 
            }
        }
        return result;
    }
}