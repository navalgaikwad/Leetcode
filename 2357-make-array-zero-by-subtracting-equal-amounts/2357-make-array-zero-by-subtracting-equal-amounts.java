class Solution {
    public int minimumOperations(int[] nums) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
//         for(int num : nums){
//             if(num!=0 && !pq.contains(num)){
//               pq.add(num);  
//             }
            
//         }
         if(nums[0] == 0 && nums.length == 1){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num!=0) {
            set.add(num);
            }
        }
       // int count =0;
       // while(!pq.isEmpty()){
       //      helper(nums, pq.remove());
       //      count++;
       //  }
        
        return set.size();
    }
    void helper(int[] nums, int val){
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
               nums[i] = Math.abs( val - nums[i] ); 
            }
            
        }
    }
}

//[1,5,0,3,5]
// [4, 0, 2, 0]
// [0,0,2,0]
// [0,0,0,0]


//[1,5,0,3,5, 6]
//[5,1,0,3,1,0]
//[0,4,0,2,4,0]
//[0,0,0,2,0,0]
//[0,0,0,0,0,0]
