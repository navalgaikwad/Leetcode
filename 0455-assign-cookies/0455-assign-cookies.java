class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        //g[10,9,8,7]
        //s[5,6,7,8]
        int left = 0;
        int right = 0;
        int count = 0;
       while(left < g.length && right < s.length) {
           if(s[right] >= g[left]) {
               count++;
               left++;
           }
           right++;
       }
        return count;
    }
}

// g = [1,2,3], s = [1,1] 
//minimum size 
//1 child 1
