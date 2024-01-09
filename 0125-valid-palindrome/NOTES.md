class Solution {
public boolean isPalindrome(String s) {
if(null == s) {
System.out.println("Input string is false");
return false;
}
if(1 > s.length() || s.length() > 200000) {
System.out.println("Input string is very small OR big" + s);
return false;
}
s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
if(s.isEmpty()) {
return true;
}
char[] chArray = s.toCharArray();
for(int i=0, j=chArray.length-1; i<=j; i++, j--) {
if(chArray[i] != chArray[j]){
return false;
}
}
return  true;
}
}