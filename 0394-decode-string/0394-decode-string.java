class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int i =0;
        String c = "";
      
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int count  = 0;
               
                while(Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                num.push(count);
            }else if(s.charAt(i)=='[') {
                    st.push(c);
                    c="";
                    i++;
                }else if(s.charAt(i)==']') {
                    int n = num.pop();
                    StringBuilder sb = new StringBuilder(st.pop());
                    while(n > 0) {
                        sb.append(c);
                        n--;
                    }
                    c = sb.toString();
                    i++;
                }else {
                    c+=s.charAt(i);
                    i++;
                }
            }
            
        return c;
    }
}