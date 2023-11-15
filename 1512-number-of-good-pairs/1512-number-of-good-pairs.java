class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        for(int num : nums){
            if(map.containsKey(num)){
                count = count +  map.get(num);
            }
            map.put(num, map.getOrDefault(num, 0)+1);
            
        }
        //System.out.print(map);
        return count;
    }
}