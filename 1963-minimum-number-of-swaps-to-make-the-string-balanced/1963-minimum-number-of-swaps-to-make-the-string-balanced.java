class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int moves =0;
        for(char c : s.toCharArray()) {
            if(c == '[') {
                st.push('[');
            }else {
                if(!st.isEmpty()) {
                    st.pop();
                }else {
                    moves++;
                }
            }
        }
        return (moves+1)/2;
    }
}