class Solution {
    public int hIndex(int[] citations) {
      int left = 0 , right = citations.length-1 , n = right+1;
      while(left < right){
        int mid = left + (right - left)/2;
        if(n-mid > citations[mid]){
            left = mid+1;
        }
        else {
            right = mid;
        }
      }
      return left==n-1 ? citations[left]>=1 ? 1 : 0 : n-left;
    }
}