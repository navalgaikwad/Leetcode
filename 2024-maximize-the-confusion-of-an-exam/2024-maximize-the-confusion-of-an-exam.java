class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
       int ans = 0;
        int max_count = 0;
        int[] count = new int[2];
        for(int l = 0,r=0;r<answerKey.length();r++)
        {
            max_count = Math.max(max_count,++count[answerKey.charAt(r) == 'T' ? 1: 0]);
            while(r-l+1 - max_count > k)
            {
                --count[answerKey.charAt(l++) == 'T'? 1 : 0];
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
   // end-s+1-maxFreq>k
    }
}

    