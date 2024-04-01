class Solution {
public String minWindow(String s, String t) {
int left =0;
// int right =0;
Map<Character, Integer> map = new HashMap<>();
for(char c : t.toCharArray()) {
map.put(c, map.getOrDefault(c, 0) + 1);
}
int counter = map.size();
int len = Integer.MAX_VALUE;
String ans = "";
for(int right = 0; right < s.length(); right++) {
char rightChar = s.charAt(right);
if(map.containsKey(rightChar)) {
map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
if(map.get(rightChar) == 0) {
counter--;
}
}
while(counter == 0) {
if(right - left + 1 < len) {
len = right - left + 1;
ans = s.substring(left, right + 1);
}
char leftChar = s.charAt(left);
if(map.containsKey(leftChar)) {
map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
if(map.get(leftChar) >0) {
counter++;
}
}
left++;
}
}
return ans;
}
}
//1. first i will take count
//2. i will go chacryer by character to find the each charcter untill that value in the map count =0
//3. onces i found i will take length and string