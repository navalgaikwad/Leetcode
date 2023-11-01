class Solution {
    public int hIndex(int[] cit) {
        //6, 5,3, 1, 0
        int n = cit.length;
        
        Arrays.sort(cit);
        
        int count = 0;
     
        //dont need to check greater because it is already sorted
        //idea is similar to jump game start from back side
        for(int i = n-1; i >= 0 && cit[i] > count ; i--){
                count ++;
        }
        
        return count;
    }
}