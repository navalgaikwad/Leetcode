class Solution {
    public boolean isInterleave(final String s1, final String s2, final String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;

        return dfs(s1, s2, s3, 0, 0, 0, new boolean[s1.length() + 1][s2.length() + 1]);
    }

    public boolean dfs(final String s1, final String s2, final String s3, final int i, final int j, final int k, final boolean[][] invalid) {
        if(k == s3.length())
            return true;

        if(invalid[i][j])
            return false;

        final boolean valid = i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i + 1, j, k + 1, invalid) ||
                            j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j + 1, k + 1, invalid);

        if(!valid)
            invalid[i][j] = true;

        return valid;
    }
}