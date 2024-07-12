
class Solution {
    public int maxProfit(int[] P, int F) {
        int len = P.length, buying = 0, selling = -P[0];
        for (int i = 1; i < len; i++) {
            buying = Math.max(buying, selling + P[i] - F);
            selling = Math.max(selling, buying - P[i]);
        }
        return buying;
    }
}