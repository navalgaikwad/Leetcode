class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int len = (nums.length/3);
        
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value > len){
                result.add(key);
            }
        }
        return result;
    }
}

//[3,2,3]
//3-2
//2-1

//3/3 =1