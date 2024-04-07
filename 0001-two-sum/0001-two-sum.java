class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        int[] val=new int[2];
       Map<Integer,Integer>map=new HashMap<>();
  
       for(int i=0;i<nums.length; i++){
           if(map.containsKey(target-nums[i])){
               val[0]=i;
               val[1]= map.get(target-nums[i]);
               break;
           }
           map.put(nums[i], i);
       }
       return val;
    }
}