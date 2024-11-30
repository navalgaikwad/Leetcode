class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums2.length; i++) {
            while(!st.isEmpty() && nums2[i] > nums2[st.peek()]) {
                map.put(nums2[st.pop()], nums2[i]);
            }
            st.push(i);
        }
        for(int i=0; i<nums1.length; i++) {
            if(map.containsKey(nums1[i])) {
                nums1[i] = map.get(nums1[i]);
            }else {
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}