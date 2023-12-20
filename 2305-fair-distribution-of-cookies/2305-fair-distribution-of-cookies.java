class Solution {
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        
        int[] child = new int[k];
        backTracking(child, cookies, 0, 0);
        return res;
    }
    
    void backTracking(int[] child, int[] cookies, int index, int max) {
        if(index == cookies.length) {
            res = Math.min(res, max);
            return;
        }
        //int c = cookies[index];
        for(int i = 0; i<child.length; i++) {
            child[i] +=cookies[index];;
            backTracking(child, cookies, index + 1, Math.max(max, child[i] ));
            child[i] -=cookies[index];;
        }
    }
}