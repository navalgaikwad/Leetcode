public class Solution {
private void solveFunc(int i, int j, int n, int k, StringBuilder tmp, StringBuilder ans) {
if (tmp.length() == n) {
if (k == j && i == n) {
if (ans.toString().compareTo(tmp.toString()) > 0) {
ans.setLength(0); // clear the StringBuilder
ans.append(tmp);
}
}
return;
}
for (int u = 1; u <= 26; u++) {
tmp.append((char) ('a' + u - 1));
solveFunc(i + 1, j + u, n, k, tmp, ans);
tmp.deleteCharAt(tmp.length() - 1); // equivalent to pop_back()
}
}
​
public String getSmallestString(int n, int k) {
StringBuilder tmp = new StringBuilder();
StringBuilder ans = new StringBuilder();
for (int i = 0; i < n; i++) {
ans.append('z'); // Initialize ans with the largest possible string
}
solveFunc(0, 0, n, k, tmp, ans);
return ans.toString();
}
}
​