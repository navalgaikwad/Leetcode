class Solution {
    public int hIndex(int[] cit) {
        //6, 5,3, 1, 0
           int n = cit.length;
        
//         if( n ==1){
//             return cit[0];
//         }
        
        Arrays.sort(cit);
        
        int count = 0;
     
        for(int i = n-1; i >= 0; i--){
            if(cit[i] > count ){
                count ++;
            }
        }
        
        return count;
    }
}