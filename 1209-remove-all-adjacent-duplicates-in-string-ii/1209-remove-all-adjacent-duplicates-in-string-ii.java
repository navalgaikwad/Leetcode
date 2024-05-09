class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<CharCounter> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && st.peek().c == c) {
                if(st.peek().count == k - 1) {
                    st.pop();
                }else {
                    st.peek().count++;
                }
            }else {
                st.push(new CharCounter(c));
            }
        }
        StringBuilder result = new StringBuilder();
        for(CharCounter cc: st) {
            result.append(cc.toString());
        }
        return result.toString();
    }
    
    class CharCounter {
        char c;
        int count;
        CharCounter(char c) {
            this.c = c;
            this.count = 1;
        }
        @Override
        public String toString() {
            return Character.toString(c).repeat(count);
        }
    }
}