class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        
        String ans = "";
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int number = 0;
            if(Character.isDigit(s.charAt(i))) {
                while(Character.isDigit(s.charAt(i))) {
                    number =number *10 + Character.getNumericValue(s.charAt(i));
                    i++;
                 }
                i--;
                numberStack.push(number);
            }else if(c == '[') {
                st.push(ans);
                ans = "";
            }else if(c == ']') {
                StringBuilder sb = new StringBuilder(st.pop());
                int value = numberStack.pop();
                while(value > 0) {
                    sb.append(ans);
                    value--;
                }
                ans = sb.toString();
            } else {
                ans+=s.charAt(i);
            }
           
            
        }
        return ans;
    }
}