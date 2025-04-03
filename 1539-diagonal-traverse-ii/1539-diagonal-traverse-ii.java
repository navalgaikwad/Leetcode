class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n =0;
        for(int i=nums.size()-1; i>=0; i--) {
            for(int j=0; j<nums.get(i).size(); j++) {
                int diagonal = i + j;
                if(!map.containsKey(diagonal)) {
                    map.put(diagonal, new ArrayList<>());
                }
                map.get(diagonal).add(nums.get(i).get(j));
                n++;
            }
        }
        int[] array = new int[n];
        int index = 0;
        int i=0;
        while(map.containsKey(index)) {
            for(Integer val: map.get(index)) {
                array[i++] = val;
            }
            index++;
        }
        return array;
        
    }
}