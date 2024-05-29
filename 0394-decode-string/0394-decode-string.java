class Solution {
    public String decodeString(String s) {
        Stack<String> characterStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        int i =0;
        int number = 0;
        String ans = "";
        String result = "";
        for(;i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                while( i < s.length() && Character.isDigit(s.charAt(i))) {
                    number = (number * 10) + s.charAt(i) - '0';
                    i++;
                }
                i--;
                numberStack.push(number);
                number = 0;
            }else if(c == '[') {
                characterStack.push(ans);
                ans = "";
            }else if(c == ']') {
                StringBuilder sb = new StringBuilder(characterStack.pop());
                int value = numberStack.pop();
                while(value > 0) {
                    sb.append(ans);
                    value--;
                }
                ans =sb.toString();
            }else {
                ans+=s.charAt(i);
                //i++;
            }
            
        }
       // System.out.print(ans);
        return ans;
    }
}

