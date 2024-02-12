class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int move =0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                st.push('(');
            }else {
                if(!st.isEmpty()) {
                    st.pop();
                }else {
                    move++;
                }
            }
        }
        return move+st.size();
    }
}
//())
//(