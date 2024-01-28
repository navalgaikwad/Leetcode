class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s: tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if(s.equals("+")) {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    int sum  = val2+val1;
                    st.push(sum);
                }else if(s.equals("-")) {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    int minus  = val2-val1;
                    st.push(minus);
                }else if(s.equals("*")) {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    int mul  = val2*val1;
                    st.push(mul);
                    
                }else if(s.equals("/")) {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    int div  = val2/val1;
                    st.push(div);
                }
               
            }else {
              st.push(Integer.parseInt(s));  
            }
             
        }
        return st.peek();
    }
}