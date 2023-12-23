class Solution {
List<List<Integer>> result = new ArrayList<>();
public List<List<Integer>> combine(int n, int k) {
List<Integer> ans = new ArrayList<>();
helper(n, k, 1, ans);
return result;
}
void helper(int n, int k, int index, List<Integer> ans){
if(ans.size() == k){
// System.out.println(index + " "+ ans);
result.add(new ArrayList<>(ans));
return;
}
for(int i = index; i <= n; i++){
// System.out.println(i);
ans.add(i);
helper(n, k, i + 1, ans);
ans.remove(ans.size() - 1);
}
}
}