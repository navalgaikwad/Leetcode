class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
       int i=0;
        int len =nums.length;
        Map<Integer, Integer>map= new HashMap<>();
        while(i<len){
           if(map.containsKey(nums[i])){
             int j=  map.get(nums[i]);
               if(Math.abs(i-j)<=k){
                  return true; 
               }
           }
            map.put(nums[i], i);
            i++;
        }
        return false;
    }
}