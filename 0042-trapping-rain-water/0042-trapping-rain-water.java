class Solution {
    public int trap(int[] h) {
      int leftMax = 0;
      int rightMax =0;
      int l=0; int r = h.length -1;
      int result =0;
      while(l<=r){
          if(h[l]<=h[r]){
              leftMax = Math.max( h[l], leftMax);
              result = result + (leftMax-h[l] );
              l++;
          }else{
              rightMax = Math.max( h[r], rightMax);
              result = result + (rightMax - h[r]);
              r--;
          }
      }
        return result;
    }
}