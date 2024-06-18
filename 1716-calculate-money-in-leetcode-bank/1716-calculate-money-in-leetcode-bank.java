class Solution {
    public int totalMoney(int n) {
        int ans =0;
        int monday = 1;
        while(n > 0) {
            for(int i=0; i<Math.min( n,7); i++) {
                ans+=monday + i;
            }
            
            monday +=1;
            n-=7;
        }
        return ans;
    }
}