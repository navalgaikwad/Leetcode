class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length-1;//imp right col length
        int top = 0, bottom = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        while(left <= right && top <= bottom) {
            for(int i = left; i <= right; i++) {
                result.add(matrix[top][i]);//vvimp top, top++
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);//vvimp right--
            }
            right--;
            if(top <= bottom) {
                for(int i = right; i>= left;i--) {
                    result.add(matrix[bottom][i]);//imp bottom
                }
                bottom--;
            }
            if(left <= right) {
                for(int i = bottom; i>= top;i--) {
                    result.add(matrix[i][left]);//vvimp left
                }
                left++;
            }
        }
        return result;
    }
}