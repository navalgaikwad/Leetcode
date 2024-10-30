class Solution {
public String minRemoveToMakeValid(String s) {
int open =0;
StringBuilder sb = new StringBuilder();
for(char c : s.toCharArray()) {
if(c == '(') {
open++;
}else if(c == ')'){
if(open == 0) {
continue;
}
open--;
}
sb.append(c);
}
StringBuilder st = new StringBuilder();
for(int i = sb.length() - 1; i>=0; i--) {
if(sb.charAt(i) == '(' && open-->0) {
continue;
}
st.append(sb.charAt(i));
}
return st.reverse().toString();
}
}