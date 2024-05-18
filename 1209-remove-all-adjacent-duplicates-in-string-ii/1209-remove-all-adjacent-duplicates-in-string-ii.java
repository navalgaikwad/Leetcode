class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(!st.isEmpty() && st.peek().c == s.charAt(i) ) {
                if(st.peek().count == k - 1) {
                    st.pop();
                }else {
                    st.peek().count++;
                }
                
            }else {
                st.push(new Pair(s.charAt(i)));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Pair sd :st) {
            sb.append(sd.toString());
        }
        return sb.toString();
    }
    
    class Pair {
        char c;
        int count;
        Pair(char c) {
            this.c = c;
            this.count = 1;
        }
        
        @Override
        public String toString() {
            return Character.toString(c).repeat(count);
        }
    }
}