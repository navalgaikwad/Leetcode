class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                open++;
            }else if(c == ')'){
                if(open == 0) {
                    continue;
                }else {
                    open--;
                }
            }
            sb.append(c);
        }
        StringBuilder result = new StringBuilder();
        int len = sb.length()-1;
        for(int i = len; i>=0; i--) {
            if(sb.charAt(i) == '(' && open-->0) {
                continue;
            }
            result.append(sb.charAt(i));
        }

        return  result.reverse().toString();
    }
}