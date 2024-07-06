class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] dp = new int[len][3];
        for(int i=0; i<len; i++) {
            dp[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(dp, (a,b) -> a[1]-b[1]);
        TreeMap<Integer, Integer> intsMap = new TreeMap<>();
        intsMap.put(0,0);
        for(var i : dp) {
            int cur = intsMap.floorEntry(i[0]).getValue() + i[2];
            if(cur > intsMap.lastEntry().getValue()) {
                intsMap.put(i[1], cur);
            }
        }
        return intsMap.lastEntry().getValue();
    }
}