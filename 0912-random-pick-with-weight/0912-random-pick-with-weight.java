class Solution {
    int[] w;
    double[] p;
    Random random;
    public Solution(int[] w) {
        random = new Random();
        this.w = w;
        double sum =0;
        this.p = new double[w.length];
        for(int we : w) {
            sum+=we;
        }
        p[0] = w[0] / sum;
        for(int i=1; i<w.length; i++) {
            p[i] = p[i-1] + (w[i]/sum); 
        }
    }
    
    public int pickIndex() {
      double target = random.nextDouble();
      int left =0;
      int right = p.length-1;
      while(left < right) {
        int mid = left + (right - left)/2;
        if(p[mid] < target) {
            left = mid + 1;
        }else {
            right = mid;
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