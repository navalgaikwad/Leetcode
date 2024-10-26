class Solution {
public String reverseWords(String s) {
int lastSpace = -1;
char[] charArray = s.toCharArray();
int len = s.length();
for(int start = 0; start <= len; start++) {
if(start == len || charArray[start] == ' ') {
int startIndex = lastSpace + 1;
int endIndex = start - 1;
while(startIndex < endIndex) {
char temp = charArray[startIndex];
charArray[startIndex] = charArray[endIndex];
charArray[endIndex] = temp;
startIndex++;
endIndex--;
}
lastSpace = start;
}
}
return new String(charArray);
}
}
​
​