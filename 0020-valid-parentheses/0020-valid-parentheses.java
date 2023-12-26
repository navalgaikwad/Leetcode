class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        Map<Character, Character> map =new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!st.isEmpty () && (c == ')' || c =='}' || c == ']')) {
                char ch = map.getOrDefault(st.peek(), '0');
                if(ch != c || ch == '0'){
                    return false;
                }
                st.pop();
            }else {
                st.push(c);
            }
        }
        if(!st.isEmpty()) {
            return false;
        }
        return true;
    }
}