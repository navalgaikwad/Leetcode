class Solution {
    public String minRemoveToMakeValid(String s) {
        //
        int open=0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                open++;
            }else if(c==')'){
                if(open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(c);
        }
        System.out.print(sb.toString());
        StringBuilder st=new StringBuilder();
        int len = sb.length();
        for(int i = len - 1; i>=0; i--) {
            if(sb.charAt(i) == '(' && open-->0) continue;
             st.append(sb.charAt(i));
        }
        return  st.reverse().toString();
    }
}
//lee(t(c)o)de)
//lee(t(c)o)de
//0
//a)b(c)d
//ab(c)d
//-1
//))((
//((
//2
