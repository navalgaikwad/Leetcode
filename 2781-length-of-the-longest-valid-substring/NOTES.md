class Solution {
//slidding window
//insider loop for(int k=right; k>=Math.max(left, right - 9); k--) { //design iterate left to right
//ask for constarint
//1 <= forbidden[i].length <= 10 so right - 9)
public int longestValidSubstring(String word, List<String> forbidden) {
HashSet<String> set = new HashSet<>(forbidden);
int left=0;
int n = word.length();
int ans =0;
for(int right = 0;right<n; right++) {
for(int k=right; k>=Math.max(left, right - 9); k--) {
if(set.contains(word.substring(k, right+1))) {
left = k + 1;//move k that much time
break;
}
}
ans = Math.max(right - left + 1, ans);
//right++;
}
return ans;
}
}