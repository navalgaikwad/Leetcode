class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        dp(nums, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }
    
    void dp(int[] nums, int index, ArrayList<Integer> answer) {
        result.add(new ArrayList<>(answer));
        for(int i=index; i<nums.length; i++) {
            //if(!answer.contains(nums[i])) {
                answer.add(nums[i]);
                dp(nums, i + 1, answer);
                answer.remove(answer.size() - 1); 
            }
            
       // }
    }
}

// class Solution {
//     HashSet<List<Integer>> result = new HashSet<>();
//     public List<List<Integer>> subsets(int[] nums) {
//         backTracking(nums, new ArrayList<>(), 0);
//        // System.out.print(result);
//         return new ArrayList<>(result);
//     }
    
//     void backTracking(int[] nums, List<Integer> runningList, int index) {
        
//         result.add(new ArrayList<>(runningList));
//         for(int i=index; i<nums.length; i++) {
//             runningList.add(nums[i]);
//             backTracking(nums, runningList, i + 1);
//             runningList.remove(runningList.size() - 1);
//         }
//     }
// }