class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int len = temperatures.length;
        int[] result = new int[len];
        for(int i =0; i<len; i++) {
            while(st.size()>0 && temperatures[st.peek()] < temperatures[i]){
                int index = st.pop();
                result[index] = i - index;
            }
            st.push(i);
        }
        
        return result;
    }
}
// 0,  1, 2 , 
//73, 74, 75, 71