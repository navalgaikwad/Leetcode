class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] num1 :nums){
            for(int num: num1){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value=  entry.getValue();
            if(value == len){
               list.add(key); 
            }
            
        }
        Collections.sort(list);
        return list;
    }
}