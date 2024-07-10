class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length - 1;
        int left =0; int right = n;
        int[] result = new int[nums.length];
        int index = n;
        while(left <= right) {
            int leftSqaure = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if(leftSqaure >= rightSquare) {
                result[index] = leftSqaure;
                left++;
            }else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }
        return result;
    }
}