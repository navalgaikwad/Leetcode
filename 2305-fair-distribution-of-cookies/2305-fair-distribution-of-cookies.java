class Solution {
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] child = new int[k];
        helper(child, cookies, 0, 0);
        return res;
    }
    
    void helper(int[] child, int[] cookies, int index, int max) {
        if(index == cookies.length) {
            res = Math.min(res, max);
            return;
        }
        for(int i=0; i < child.length; i++) {
            child[i]+=cookies[index];
            helper(child, cookies, index + 1, Math.max(max, child[i]));
            child[i]-=cookies[index];
        }
    }
}