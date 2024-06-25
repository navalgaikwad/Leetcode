class Solution {
int max = 0;
public int maxLength(List<String> arr) {
helper(arr, "", 0);
return max;
}
void helper(List<String> arr, String newString, int index) {
max = Math.max(max, newString.length());
for(int i=index; i<arr.size(); i++) {
if(!check(newString, arr.get(i))) {
continue;
}
helper(arr, newString + arr.get(i), i + 1);
}
}
boolean check(String s, String newString) {
int[] count = new int[26];
for(int i=0; i<newString.length(); i++) {
++count[newString.charAt(i) - 'a'];
if(count[newString.charAt(i) - 'a'] == 2) {
return false;
}
if(s.contains(newString.charAt(i)+"")) {
return false;
}
}
return true;
}
}