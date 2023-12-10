class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left =0;
        int right = price[price.length-1] - price[0];
        while(left<=right) {
            int mid = left + (right- left)/2;
            if(helper(price, k, mid)) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }
    
    boolean helper(int[] price, int k, int gap) {
        int count = 1;
        int previous = price[0];
        for(int i=1; i<price.length; i++) {
            if(price[i] - previous >= gap) {
                count++;
                previous = price[i];
            }
        }
        return count>=k;
    }
}