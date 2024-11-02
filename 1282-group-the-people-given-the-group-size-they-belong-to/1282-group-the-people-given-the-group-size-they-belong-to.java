class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i< groupSizes.length; i++) {
            if(!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            ArrayList<Integer> list = map.get(groupSizes[i]);
            list.add(i);
            if(list.size()== groupSizes[i]) {
                ans.add(list);
                map.remove(groupSizes[i]);
            }
        }
        return ans;
    }
}