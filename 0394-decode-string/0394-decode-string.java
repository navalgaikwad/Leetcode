class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> aplhaStack = new Stack<>();
        
        int len = s.length();
        String val ="";
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int number =0;
                while(Character.isDigit(s.charAt(i)) && i < len) {
                    number =number *10 +( s.charAt(i) - '0');
                    i++;
                }
                numberStack.push(number);
                i--;
            }else if(c == '[') {
                aplhaStack.push(val);
                val = "";
            }else if(c == ']') {
                StringBuilder sb = new StringBuilder(aplhaStack.pop());
                int num = numberStack.pop();
                while(num > 0) {
                    sb.append(val);
                    num--;
                }
                
                val=sb.toString();
            }else {
                val+=c;
            }
        }
        return val;
    }
}