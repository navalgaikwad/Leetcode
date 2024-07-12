class Solution {
    public int carFleet(final int target, final int[] position, final int[] speed) {
        final int n = position.length;
        final double[] time = new double[target];

        for(int i = 0; i < n; ++i)
            time[position[i]] = (double) (target - position[i]) / speed[i];

        double prev = 0.0;
        int res = 0;

        for(int i = target - 1; i >= 0; --i) {
            final double cur = time[i];

            if(cur > prev) {
                prev = cur;
                res++;
            }
        }

        return res;
    }
}