class Solution {
public boolean canChange(String s, String t) {
int n = s.length();
int i = 0, j = 0;
​
while (i < n && j < n) {
// Skip underscores in both strings
while (i < n && s.charAt(i) == '_') i++;
while (j < n && t.charAt(j) == '_') j++;
​
// If both pointers reached the end, strings are equivalent
if (i == n && j == n) return true;
// If one pointer reached the end but the other didn't, not equivalent
if (i == n || j == n) return false;
​
// Check if characters at the current pointers are different
if (s.charAt(i) != t.charAt(j)) return false;
​
// Check if 'L' is moving to the left and 'R' is moving to the right
if (s.charAt(i) == 'L' && i < j) return false;
if (s.charAt(i) == 'R' && i > j) return false;
​
// Move both pointers forward
i++;
j++;
}
​
// Skip any remaining underscores
while (i < n && s.charAt(i) == '_') i++;
while (j < n && t.charAt(j) == '_') j++;
​
// Both pointers should reach the end for strings to be equivalent
return i == n && j == n;
}
}
​