// class Solution {
//     public int numDecodings(String s) {
//         return dfs(s);
//     }
    
//     int dfs(String s) {
//         if(s.isEmpty()) {
//             return 1;
//         }
//         int count = 0;
//         if(s.charAt(0) != '0') {
//             count += dfs(s.substring(1));
//         }
//         if(s.length() >= 2 && s.charAt(0) != '0' && Integer.parseInt(s.substring(0, 2)) <= 26) {   
//             count += dfs(s.substring(2));
//         }
//         return count;
//     }
// }

class Solution {
    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        return dfs(s, 0, memo);
    }
    
    int dfs(String s, int index, Integer[] memo) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        int count = dfs(s, index + 1, memo);
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            count += dfs(s, index + 2, memo);
        }
        memo[index] = count;
        return count;
    }
}

//either i can select one or 2
//if select 1 need to check not 0
//if select 2 need to check not 0 and not 7
//need to take a count