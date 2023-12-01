class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int len = nums2.length;
        
        Map<Integer, Integer> map =new HashMap<>();
        for(int i =0; i<len; i++) {
            while(st.size()>0 && nums2[st.peek()] < nums2[i]){
                int index = st.pop();
                map.put(nums2[index], nums2[i]);
            }
            st.push(i);
        }
        int[] result = new int[nums1.length];
        int i =0 ;
        for(int nums : nums1){
            result[i++] = map.getOrDefault(nums, -1);
        }
        
        return result;
    }
}
