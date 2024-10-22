class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int max = 0;
        //set.add(0);
        for(int i= 0; i< nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {//not in set
                int count = 1;
                int number = nums[i] + 1;
                while(set.contains(number)) {
                    count++;
                    number = number + 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}