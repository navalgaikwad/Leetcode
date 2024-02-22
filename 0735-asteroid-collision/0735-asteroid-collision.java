class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        for(int a : ast) {
            boolean flag = true;
            while(!st.isEmpty() && st.peek()>0&& a<0) {
                if(st.peek() > -(a)) {
                    flag = false;
                    break;
                }else if(st.peek() < -(a)) {
                    st.pop();
                }else if(st.peek() == -(a)) {
                    st.pop();
                    flag = false;
                    break;
                }
            }
            if(flag) {
             st.push(a);   
            }
        }
        // int[] result = new int[st.size()];
        // int i =0;
        // while(!st.isEmpty()) {
        //     result[i++] = st.pop();
        // }
       // Collections.reverse(Arrays.asList(result)); 
        return  st.stream().mapToInt(i->i).toArray();
    }
}