class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = Arrays.stream(sweetness).min().getAsInt();
        int right = Arrays.stream(sweetness).sum();
        int ans =0;
        while(left <= right) {
            int mid =left + (right - left)/2;
            if(helper(sweetness,k,mid)) {
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
    
    boolean helper(int[] sweetness, int k, int mid) {
        int count =0;
        int sum =0;
        for(int sweet:sweetness) {
            sum+=sweet;
            if(sum > mid) {
                sum = 0;
                count++;
            }
        }
        
        return count <= k;
        
    }
}