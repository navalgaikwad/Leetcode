class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int curr = 0;
        int ans = 0;
        int len = nums.length;
        map.put(0, 1);//add default value
        for(int i = 0; i<len; i++){
            curr = curr + (nums[i]%2);//odd no
            
            if(map.containsKey(curr - k)){
                ans = ans + map.get(curr - k);
            }
            
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        //System.out.print(map);
        return ans;
    }
}