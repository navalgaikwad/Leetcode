class Solution {
    public List<Integer> intersection(int[][] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] num : nums){
            for(int n: num){
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value == len){
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }
}