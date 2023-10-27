public List<List<String>> partition(String s) {
List<List<String>> result = new ArrayList<List<String>>();
helper(0,  new ArrayList<String>(), result, s);
return result;
}
void helper(int start, List<String> runningList,  List<List<String>> result, String s){
if(start >=s.length()){
result.add(new ArrayList<>(runningList));
return;
}
for(int i=start; i<s.length(); i++){
if(palindrome(start, i, s)){
runningList.add(s.substring(start, i+1));
helper(i+1, runningList, result, s);
runningList.remove(runningList.size()-1);
}
}
}
boolean palindrome(int s, int e, String st){
while(s<e){
if(st.charAt(s++)!=st.charAt(e--)){
return false;
}
}
return true;
}
static String helper(String s, HashMap<String, Integer> memo, int j){
if(memo.containsKey( s )){
return memo.get( s );
}
if(subString.equals("")){
String base= new String();
return base;
}
for(int i=0; i<s.length(); i++){
helper(s.substring(i, j+1), memo, j+1);
}