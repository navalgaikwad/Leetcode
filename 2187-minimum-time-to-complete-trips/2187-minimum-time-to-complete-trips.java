class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = 100000000000000L;
        while(left < right) {
            long mid = left + (right-left)/2;
            if(compelteTheTrip(time, mid, totalTrips) >= totalTrips) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    long compelteTheTrip(int[] times, long currentTime, int totalTrips) {
        long count = 0;
        for(int time : times) {
            long t = (long)time;
            count += currentTime / t;
            if(count >= totalTrips ){//count is greater than totalTrips break it
                break;
            }
        }
        return count;
    }
}