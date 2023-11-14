class Solution {
    public int trap(int[] h) {
        //logic is on every left check which is greater
        int left = 0; //satrt from 0
        int right = h.length - 1 ;// end
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while(left <= right){
            if(h[left]<=h[right]){//max : 1
                leftMax = Math.max(leftMax, h[left]);
                result = result + (leftMax - h[left]);
                left++;
            }else{
                rightMax = Math.max(rightMax, h[right]);
                result = result + (rightMax - h[right]);
                right--; 
            }
        }
        return result;
    }
}