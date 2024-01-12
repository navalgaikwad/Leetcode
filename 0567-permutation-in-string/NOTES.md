import java.util.HashMap;
import java.util.Map;
​
public class Solution {
public boolean checkInclusion(String s1, String s2) {
Map<Character, Integer> map = new HashMap<>();
for (char c : s1.toCharArray()) {
map.put(c, map.getOrDefault(c, 0) + 1);
}
int counter = map.size();
int left = 0;
​
for (int right = 0; right < s2.length(); right++) {
if (map.containsKey(s2.charAt(right))) {
map.put(s2.charAt(right), map.get(s2.charAt(right)) - 1);
if (map.get(s2.charAt(right)) == 0) {
counter--;
}
}
​
while (counter == 0) {
if (right - left + 1 == s1.length()) {
return true;
}
​
if (map.containsKey(s2.charAt(left))) {
map.put(s2.charAt(left), map.get(s2.charAt(left)) + 1);
if (map.get(s2.charAt(left)) > 0) {
counter++;
}
}
left++;
}
}
​
return false;
}
}
​