class Solution {
public boolean repeatedSubstringPattern(String s) {
int n = s.length();
for(int i=n/2; i>=1;i--) {
if(n%i==0) {
if(s.substring(0, n-i).equals(s.substring(i))) {
return true;
}
}
}
return false;
}
}
//abab
//ab ab
//