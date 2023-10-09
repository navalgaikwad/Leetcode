class Solution {
    public int maximumUnits(int[][] boxTypes, int t) {
        int sum=0;
       Arrays.sort(boxTypes, (a,b)->(b[1]-a[1]));
//         for(int[]  box: boxTypes){
//             int val1 = box[0];
//             int val2 = box[1];
             
//             if(val1<=t){
                
//                 if(val1<t){
//                    sum=sum+ (val1*val2); 
//                 }
//                  t=t-val1;
                
//             }else{
                     
//                 sum=sum+ (t*val2); 
//                 t=val1-t;
//                 }
//         }
//         return sum;
//     }
        int i=0;
        while(t>0 && i<boxTypes.length){
            int units = boxTypes[i][1];
            int boxesToPick = Math.min(t, boxTypes[i][0]);
            sum = sum + units * boxesToPick;
            t = t - boxesToPick;
            i++;
        }
        return sum;
    }
}