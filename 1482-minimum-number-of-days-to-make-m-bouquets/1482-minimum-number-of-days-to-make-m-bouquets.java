class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int minDay = Arrays.stream(bloomDay).min().getAsInt();
        int maxDay = Arrays.stream(bloomDay).max().getAsInt();
        int  ans = -1;
        while(minDay <= maxDay) {
            int mid = minDay + (maxDay - minDay)/2;
            if(check(bloomDay, m, k, mid)) {
              ans = mid;
              maxDay = mid - 1;  
            }else {
              minDay = mid + 1;
            }
        }
        return ans;
    }
    
    boolean check(int[] bloomDay, int m, int k, int mid) {
        int count = 0; int bouquets = 0;
        for(int bloom: bloomDay) {
            if(bloom <= mid) {
                count++;
            }else {
                count =0;
            }
            if(count == k) {
                bouquets++;
                count =0;
            }
        }
        return bouquets>=m;
    }
}