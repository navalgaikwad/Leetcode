/*
 * ans[i] = ans[i-1]*10 <= n ? ans[i-1]*10 : ans[i-1]%10 < 9 ? ans[i-1] + 1 : ans[i-1]/10%10 < 9 ? ...
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        ans.add(1);
        int prev = 1;
        for (int i = 1; i < n; ++i) {
            if (prev * 10 <= n) {
                prev *= 10;
            } else {
                while (prev % 10 == 9 || prev == n) 
                    prev /= 10;
                prev++;
            }
            ans.add(prev);
        }
        return ans;
    }
}