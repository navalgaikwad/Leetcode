class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i =0;
        for(int num : nums){
            if(map.containsKey(target - num)){
                int[] result = new int[2];
                result[0] = i;
                result[1] = map.get(target - num);
                return result;
            }
            map.put(num, i);
            i++;
        }
        return new int[]{};
    }
}

//nums = [2,7,11,15], target = 9
//9-2 = 7  
//2 