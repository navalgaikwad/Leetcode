class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        //find next greater elemnt
        for(int i=0; i<nums2.length; i++) {
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        int[] result = new int[nums1.length];
       int i=0;
        for(int num : nums1) {
            result[i++] = map.getOrDefault(num, -1);
        }
        //System.out.print(map);
        return result;
    }
}