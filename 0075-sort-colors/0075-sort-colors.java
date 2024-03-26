class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        for(int i =0 ;i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int j =0;
        for(int i=0; i<3; i++) {
            while(map.get(i) > 0) {
                nums[j++] = i;
                map.put(i, map.get(i) - 1);
            }
        }
    }
}
