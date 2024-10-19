class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0; int right = matrix[0].length - 1;
        int top = 0; int bottom = matrix.length -1;
        List<Integer> answer = new ArrayList<>();
           if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return answer;
        }
        
        while(left <= right && top <= bottom) {
            for(int i = left; i <= right; i++) {
                answer.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom) {
                for(int i=right; i >= left; i--) {
                answer.add(matrix[bottom][i]);
                }
                bottom--;
            }
             if(left <= right) {
                for(int i=bottom; i >=top; i--) {
                    answer.add(matrix[i][left]);
                    }
                left++;
            }
        }
        return answer;
    }
}