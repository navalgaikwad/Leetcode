class Solution {
    public int[] diStringMatch(String s) {
        //first we have 2 input I and D
       //s[i] =='I' perm[i] < perm[i + 1]
       //s[i] == 'D'  if perm[i] > perm[i + 1]
        // IDID s=2 d=3
        //[0, 4, 1, 3, 2]
        int low =0;
        int high =s.length();
        int[] ans=new int[high+1];
        for(int i=0; i<s.length(); i++){
           if(s.charAt(i)=='I'){
              ans[i]=low;
              low++;
           } else{
              ans[i]=high;
              high--; 
           }
        }
        ans[s.length()]=low;
        return ans;
    }
}