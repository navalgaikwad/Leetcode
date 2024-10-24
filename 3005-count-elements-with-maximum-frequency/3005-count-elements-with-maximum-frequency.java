class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max =0;
        int[] map = new int[101];
        for(int num : nums) {
            map[num]++;
            max = Math.max(max, map[num]);
        }
        int ans =0;
        for(Integer value: map) {
            if(max == value) {
                ans+=value;
            }
        }
        return ans;
    }
}