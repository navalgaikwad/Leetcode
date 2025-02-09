class Solution {
    Random dom = new Random();
    int[] wSum;
    public Solution(int[] w) {
        for(int i=1; i<w.length; ++i) {
            w[i] +=w[i-1];
        }
        this.wSum = w;
    }
    
    public int pickIndex() {
        int left =0;
        int right = wSum.length -1;
        int idx = dom.nextInt(wSum[wSum.length - 1]) + 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(idx == wSum[mid]) {
                return mid;
            }
            if(idx < wSum[mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */