class Solution {
    public int minCost(String colors, int[] neededTime) {
        int left = 0;
        int result = 0;
        for(int right = 1; right < colors.length(); right++) {
            char c = colors.charAt(right);
            if(c ==  colors.charAt(left)) {
                if(neededTime[left] < neededTime[right]) {
                    result+=neededTime[left];
                    left = right;
                }else {
                    result+=neededTime[right];
                }
            }else {
                left = right;
            }
        }
        return result;
    }
}