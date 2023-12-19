void dfs(String s, int i, String ans, int part, List<String> result){
if(part==4 || i==s.length()){
if(part==4 && i==s.length()){
result.add(ans.substring(0, ans.length()-1));
}
return;
}
dfs(s, i+1, ans+s.charAt(i)+".", part+1, result);
if(i+2<=s.length()&& isvalid(s.substring(i, i+2))){
dfs(s, i+2, ans+s.substring(i, i+2)+".", part+1, result);
}
if(i+3<=s.length()&& isvalid(s.substring(i, i+3))){
dfs(s, i+3, ans+s.substring(i, i+3)+".", part+1, result);
}
}
boolean isvalid(String s){
if(s.charAt(0)=='0'){
return false;
}
int temp = Integer.parseInt(s);
return temp<=255;
}