class Solution {
    public int maxFrequencyElements(int[] nums) {
        if(nums.length == 0) return 0; 
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > max) {
                max = map.get(num);
            }
        }
       // System.out.print(map);
        int count = 0;
        for(Integer value : map.values()) {
            if(value == max) {
                //System.out.print(map.get(num));
                count+=max;
            }
        }
        return count;
    }
}