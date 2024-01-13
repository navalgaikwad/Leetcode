class Solution {
     int atMost(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left =0 ;
        //int right =0;
        int count =0;
        for(int right = 0; right< nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > k){
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count = count + (right - left + 1);
        }
        return count;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        //System.out.print();
        return atMost(nums, k) - atMost(nums, k - 1) ;
    }
}