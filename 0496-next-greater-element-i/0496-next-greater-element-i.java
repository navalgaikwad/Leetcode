class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int len = nums2.length;
        for(int i=0; i<len; i++) {
            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
                int index = st.pop();
                map.put(nums2[index], nums2[i]);
            }
            st.push(i);
        }
        
        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return result;
    }
}