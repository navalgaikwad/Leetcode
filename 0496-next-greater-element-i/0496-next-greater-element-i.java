class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums2){
            while(!st.isEmpty() && st.peek() < num){
                 map.put(st.pop(), num); //next greter element 1, 3
            }
            st.push(num);//3
           
        }
        int[] result = new int[nums1.length];
        int i=0;
        for(int num : nums1){
            result[i++] =map.getOrDefault(num, -1);
        }
        return result;
    }
}