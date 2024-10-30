```
class Solution {
public String convert(String s, int numRows) {
if (numRows == 1 || numRows >= s.length()) {
return s;
}
ArrayList<Character>[] result = new ArrayList[numRows];
for (int i = 0; i < numRows; i++) {
result[i] = new ArrayList<>();
}
int index = 0;//maintain the index for string index
while (index < s.length()) {
//go to 0 to last
for (int j = 0; j < numRows && index < s.length(); j++) {
result[j].add(s.charAt(index++));
}
//last -2 to 1
for (int j = numRows - 2; j >= 1 && index < s.length(); j--) {
result[j].add(s.charAt(index++));
}
}
StringBuilder sb = new StringBuilder();
for (int k = 0; k < result.length; k++) {
for (char c : result[k]) {
sb.append(c);
}
}
return sb.toString();
}
}
​
```