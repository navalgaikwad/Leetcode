class Solution {
int max=0;
public int maxLength(List<String> arr) {
dfs( arr,0,  "");
return max;
}
void dfs(List<String> arr, int curr, String current){
if(max < current.length()){
max = current.length();
}
for(int i = curr; i< arr.size(); i++){
if(!isValid(current,  arr.get(i))){ //
continue;
}
dfs(arr, i+1, current+arr.get(i));
}
}
​
boolean isValid(String current, String newString){
int[] count = new int[26];
for(int i=0;i<newString.length(); i++){
++count[newString.charAt(i) - 'a'];
if(count[newString.charAt(i) - 'a'] == 2){ //duplicate
return false;
}
if(current.contains(newString.charAt(i)+"")){//check for duplicate entry
return false;
}
}
return true;
}
}