class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> al = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int index = -1;
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] == key && Math.abs(i - j) <= k) {
                    index = i;
                }
            }
            if(index != -1) {
                al.add(index);
            }
        }
        return al;
    }
}