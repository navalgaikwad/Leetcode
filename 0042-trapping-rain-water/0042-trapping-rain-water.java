class Solution {
    public int trap(int[] h) {
        int left =0;
        int right = h.length -1;
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right) {
            if(h[left] <= h[right]) {
               leftMax = Math.max(leftMax, h[left]);//find max from right
               result = result + (leftMax - h[left]);//substract from current value from max then add it to result;
               left++;
            }else {
               rightMax = Math.max(rightMax, h[right]);
               result = result + (rightMax - h[right]);
               right--;
            }
        }
        return result;
    }
}