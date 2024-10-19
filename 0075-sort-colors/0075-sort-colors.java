class Solution {
    public void sortColors(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i =0;
        for(Integer key :map.keySet()) {
            int value = map.get(key);
            while(value > 0) {
                nums[i++] = key;
                value--;
            }
        }
    }
}

//[2,0,2,1,1,0]
//[0,        2]
//[0,0,]