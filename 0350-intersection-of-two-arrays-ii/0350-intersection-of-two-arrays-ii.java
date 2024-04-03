class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int i=0; i<nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) >= 1) {
                list.add(nums2[i]);
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) - 1);
            }
        }
        int[] result = new int[list.size()];
        int i =0;
        for(Integer l : list) {
            result[i++] = l;
        }
        return result;
    }
}