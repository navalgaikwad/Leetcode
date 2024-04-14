class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        Stack<Integer> number = new Stack<>();
        String buildString = "";
        StringBuilder result = new StringBuilder();
        for(int i =0; i<s.length(); i++) {
            char value = s.charAt(i);
            if(Character.isDigit(s.charAt(i))) {
                int count = 0;
                while(Character.isDigit(s.charAt(i))) {
                    count = count * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
              number.push(count);
              i--;
             //i++;
            }else if(value == '[') {
                st.push(buildString);
                buildString="";
            }else if(value == ']') {
                StringBuilder sb = new StringBuilder(st.pop());
                int no = number.pop();
                while(no-- > 0) {
                    sb.append(buildString);
                }
                buildString = sb.toString();
            }else {
                buildString+=s.charAt(i);
            }
        }
        return buildString;
    }
}