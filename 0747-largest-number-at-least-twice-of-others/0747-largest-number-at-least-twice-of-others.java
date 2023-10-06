class Solution {
    public int dominantIndex(int[] nums) {
       
         int len=nums.length-1;
        HashMap<Integer,Integer>map= new HashMap<>();
        for(int i=0; i<len+1; i++){
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int largest= nums[len];
        System.out.print(largest);
        int count=0;
        for(int i=0; i<len; i++){
            if(2*nums[i]>largest){
                return -1;
            }
          
        }
        
        
        
        return map.get(nums[len]);
    }
}

//find largest and do half
// check with other element