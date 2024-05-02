

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left =0;
        int cost = 0;
        
        int max = 0;
        for(int right = 0; right < s.length(); right++) {
            cost+=Math.abs(s.charAt(right)-t.charAt(right));
            if(cost > maxCost) {
                cost-=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            max = Math.max(max, right - left  + 1);
        }
        return max;
    }
}

