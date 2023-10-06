class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count=0;
       for(int i=0;i<dominoes.length-1;i++){
           int one=dominoes[i][0];
           int second=dominoes[i][1];
           for(int j=i+1;j<dominoes.length;j++){
               int check1=dominoes[j][0];
               int check2=dominoes[j][1];
               if(one==check1){
                   if(second==check2){
                       count+=1;
                   }
               }
               else if(one==check2){
                   if(second==check1){
                       count+=1;
                   }
               }
           }
       }
return count;

    }
}