}
if(s.charAt(start) == '0') {
return 0;
}
if(memo.containsKey(start)) {
return memo.get(start);
}
int count = helper(s, start + 1, memo);
if(start + 2 <= s.length() && Integer.parseInt(s.substring(start, start + 2)) <= 26) {
count+= helper(s, start + 2, memo);
}
memo.put(start, count);
return count;
}
}
​
class Solution {
List<String> list = new ArrayList<>();
public int numDecodings(String s) {
int value = helper(s, 0, "");
//System.out.print(list);
return value;
}
int helper(String s, int index, String currentDecoding) {
if (index == s.length()) {
list.add(currentDecoding);
return 1;
}
if (s.charAt(index) == '0') {
return 0;
}
int total = 0;
// Single digit decoding