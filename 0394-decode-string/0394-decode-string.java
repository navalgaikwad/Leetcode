class Solution {
    public String decodeString(String s) {
        String result = "";
        int index =0;
        Stack<String> st = new Stack<>();
        Stack<Integer> stnum = new Stack<>();
        String str = "";
        while(index < s.length()) {
            char c = s.charAt(index);
            if(Character.isDigit(c)) {
                int number = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))) {
                    number = number * 10 + (s.charAt(index) - '0');
                    index++;
                }
                stnum.push(number);
                index--;
            }else if( c == '[') {
                st.push(result);
                result = "";
               
            }else if(c == ']') {
                StringBuilder running = new StringBuilder(st.pop());
                int value = stnum.pop();
               // char ch = st.pop();
                for(int i=0; i<value; i++) {
                    running.append(result);
                }
                result = (running.toString());

            }else {
                result+=c;
            }
             index++;

        }
        return result;
    }
}