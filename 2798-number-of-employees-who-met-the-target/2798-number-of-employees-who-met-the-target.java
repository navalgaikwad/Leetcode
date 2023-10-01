class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int t) {
       int count=0;
       for(int i=0; i<hours.length; i++){
           if(hours[i]>=t){
              count++; 
           }
       }
        return count;
    }
}