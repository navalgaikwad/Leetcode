class Solution {
    public int minCost(String colors, int[] neededTime) {
        int needTime =0;
        int left =0;
        for(int right=1; right< colors.length(); right++) {
            if(colors.charAt(left) == colors.charAt(right)) {
                if(neededTime[left] <= neededTime[right]) {
                    needTime+=neededTime[left];
                    left = right;
                }else {
                    needTime+=neededTime[right];
                }
            }
            else {
                left = right;
            }
        }
        return needTime;
    }
}