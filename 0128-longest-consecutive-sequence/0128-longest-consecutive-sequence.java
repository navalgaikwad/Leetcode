class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
    
         int max =0;
         int largestStreak = 0;
        
        for(int i =0; i<nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {
                //set.add(num[i]);
                int currentStreak = 1;
                int value = nums[i] + 1;
                while(set.contains(value)) {
                    value = value + 1;
                    currentStreak++;
                }
                 largestStreak = Math.max(largestStreak, currentStreak); 
            }
          
        }
        return largestStreak;
    }
}

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         for(int num : nums) {
//             set.add(num);
//         }
//         int largestStreak = 0;
//         for(int i=0; i<nums.length; i++) {
//             int num = nums[i];
//             if(!set.contains(num - 1)) {
//                 int currentStreak = 1;
//                 int nextNo = num;
//                 while(set.contains(nextNo+1)) {
//                     nextNo++;
//                     currentStreak++;
//                 }
//                 largestStreak = Math.max(largestStreak, currentStreak);
//             }
//         }
//         return largestStreak;
//     }
// }