class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && st.peek().c == c) {
                if(st.peek().count == k-1) {
                    st.pop();
                }else {
                    st.peek().count++;   
                }
                
            }else {
                st.push(new Pair(c));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Pair sd :st) {
            sb.append(sd.toString());
        }
        return sb.toString();
        
    }

    class Pair {
        int count = 1;
        char c;
        Pair(char c) {
            this.c = c;
        }
        @Override
        public String toString() {
            return Character.toString(c).repeat(count);
        }
    }
}