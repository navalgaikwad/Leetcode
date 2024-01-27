class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int largestStreak = 0;
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(!set.contains(num - 1)) {
                int currentStreak = 1;
                int nextNo = num;
                while(set.contains(nextNo+1)) {
                    nextNo++;
                    currentStreak++;
                }
                largestStreak = Math.max(largestStreak, currentStreak);
            }
        }
        return largestStreak;
    }
}