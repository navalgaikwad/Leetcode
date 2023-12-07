class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length - 1 > hour) {
            return -1; // Impossible to travel even if speed is infinite
        }

        int left = 1;
        int right = 1_000_000_000; // Set a high enough upper limit
        int minSpeed = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double totalHour = helper(dist, mid);
            if (totalHour <= hour) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }

    private double helper(int[] dist, int speed) {
        double sum = 0.0;
        for (int i = 0; i < dist.length - 1; i++) {
            sum += Math.ceil((double) dist[i] / speed);
        }
        sum += (double) dist[dist.length - 1] / speed; // For the last segment, exact time is fine
        return sum;
    }
}
