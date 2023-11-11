class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>st=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();


        for(Integer num:nums2){
            while(!st.isEmpty() && st.peek()<num){
                map.put(st.pop(), num);
            }
            st.push(num);

        }
        int i=0;
        for(Integer val: nums1){
            nums1[i]= map.getOrDefault( val,-1);
            i++;

        }
        return nums1;
    }
}