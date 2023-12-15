
class Solution {
    public long minimumRemoval(int[] beans) {
        long len = beans.length;
        long ans = Long.MAX_VALUE, sum=0;

        for(int bean:beans) sum+=bean;
        Arrays.sort(beans);
        
        for(int i=0; i<len; i++){
            ans = Math.min(ans, sum-(len-i)*beans[i]);
        }
        return ans;
    }
}