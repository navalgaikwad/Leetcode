class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] num1 : nums){
            for(int num: num1){
               map.put(num, map.getOrDefault(num, 0) + 1); 
            }
        }
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> mapSet : map.entrySet()){
            int key = mapSet.getKey();
            int value = mapSet.getValue();
            if(value == len){
                list.add(key);
            }
        }
        Collections.sort(list);
        return list;
    }
}