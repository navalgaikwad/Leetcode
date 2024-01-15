class Solution {
    public String minRemoveToMakeValid(String s) {
        char[]  ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int open =0;
        for(int i =0; i<ch.length; i++) {
            if(ch[i]=='('){
                open++;
            }else if(ch[i] == ')') {
                if(open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(ch[i]);
        }
         StringBuilder st=new StringBuilder();
        for(int i =sb.length()-1; i>=0; i--) {
            if(sb.charAt(i) == '(' && open-->0) continue;
            st.append(sb.charAt(i));
        }
        return st.reverse().toString();
    }
}
//count open brackegts
//when pop ccheck opn cnt ==0 dont do anything
//append from end and reverse