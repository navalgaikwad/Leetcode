class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length() ;
        int[] plates = new int[len];
        int[] leftCandels = new int[len];
        int[] rightCandels = new int[len];
        
        //plates[i]
        int count =0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '*') {
                count++;
            }
            plates[i] = count;
        }
        
        //calculate candels from left
         int index = -1;
         for(int i= len - 1; i >= 0; i--) {
             if(s.charAt(i) == ('|')) {
                index = i;
            }
            leftCandels[i] = index;
        }
        
        // //calculate candels from right
         index = -1;
         for(int i=0; i < len; i++) {
             if(s.charAt(i) == ('|')) {
                index = i;
            }
            rightCandels[i] = index;
        }
        
        //then find the left index and right index and leftIndex < rightIndex
        int[] result = new int[queries.length];
        int k = 0;
        for(int[] query:queries) {
            
            int value1 = query[0];
            int value2 = query[1];
            
            int leftIndex = leftCandels[value1];
            int rightIndex = rightCandels[value2];
            
            if(leftIndex != -1 && rightIndex != -1 && leftIndex < rightIndex) {
               result[k++] = Math.abs(plates[rightIndex] - plates[leftIndex]);
            }else {
               result[k++] = 0;
            }
        }
        
       
        return result;
       // return new int[]{};
    }
}