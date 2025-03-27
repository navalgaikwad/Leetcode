class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                open++;
            }else {
                if(open > 0) {
                    sb.append("(");
                    open--;
                }else {
                    close++;
                }
            }
            sb.append(c);
        }
        int val = open;
        while(val-- > 0) {
            sb.append(")");
        }
        System.out.print(sb.toString());
        return open + close;
    }
}