class Solution {
    public int minCost(String colors, int[] neededTime) {
        int left =0;
        int timeNeed = 0;
        for(int right = 1; right < colors.length(); right++) {
            if(colors.charAt(left) == colors.charAt(right)) {
                if(neededTime[left] < neededTime[right]) {
                    timeNeed+=neededTime[left];
                    left = right;
                }else {
                    timeNeed+=neededTime[right];
                }
            }else {
                left = right;
            }
            
        }
        return timeNeed;
    }
}