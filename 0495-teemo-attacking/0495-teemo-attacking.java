class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int n = timeSeries.length;
    if (n == 0) return 0;

    int total = 0;
    for(int i = 0; i < n - 1; i++){
        if(timeSeries[i+1]-timeSeries[i]>duration){
           total=total+ duration;
        }else{
           total=total+ timeSeries[i+1]-timeSeries[i];
        }
    }
     
        
    return total + duration;
  }
}