class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
     Set<List<Integer>> result = new HashSet();
        helper(nums,0 , result);
        return new ArrayList<>(result);
    }
    
     void helper(int[] nums, int start, Set<List<Integer>> result){
        if(start==nums.length){
              result.add(arrayToList(nums));
            return;
        }
        
        for(int i= start; i<nums.length; i++){
                
                swap(nums, i, start);
                helper(nums, start+1, result);
                swap(nums, i, start);
        
        }
    }
      private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private List<Integer> arrayToList(int[] nums) {
            List<Integer> list = new ArrayList();
            for (int n : nums)
                list.add(n);
            return list;
        }
}

//    public List<List<Integer>> permuteUnique(int[] nums) {
//             Set<List<Integer>> result = new HashSet();
//             permute(nums, 0, result);
//             return new ArrayList(result);
//         }

//         private void permute(int[] nums, int st, Set<List<Integer>> result) {
//             if (st == nums.length)
//                 result.add(arrayToList(nums));
//             for (int i = st; i < nums.length; i++) {
//                 swap(nums, i, st);
//                 permute(nums, st + 1, result);
//                 swap(nums, i, st);
//             }
//         }

//         private void swap(int[] nums, int i, int j) {
//             int temp = nums[i];
//             nums[i] = nums[j];
//             nums[j] = temp;
//         }

//         private List<Integer> arrayToList(int[] nums) {
//             List<Integer> list = new ArrayList();
//             for (int n : nums)
//                 list.add(n);
//             return list;
//         }
//     }
