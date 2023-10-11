class Solution {
    public int trap(int[] h) {
        int l=0;
        int r=h.length-1;
        int result=0;
        int leftMax=0;
        int rightMax = 0;
        while(l <= r){
            if(h[l ] <= h[r]){
                leftMax = Math.max(leftMax, h[l]);
                result = result+(leftMax - h[l]);
                l++;
            }else{
                rightMax = Math.max(rightMax, h[r]);
                result = result + (rightMax - h[r]);
                r--;
            }
        }
        
        return result;
    }
}