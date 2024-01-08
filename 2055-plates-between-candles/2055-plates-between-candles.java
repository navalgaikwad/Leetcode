class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] leftSideCandles = new int[len];
        int[] rightSideCandles = new int[len];
        int[] plates = new int[len];
        
        //1. count stars
        //2.count candles from left and right side
        //plates[i]
        int count =0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '*') {
                count++;
            }
            plates[i] = count;
        }
        
         count=-1;
        for(int i=0; i<len; i++) {
            if(s.charAt(i)=='|') {//candel asel tar count kar
                count = i;
            }
            rightSideCandles[i] = count;
        }
        
        count =-1;//vv imp -1
        for(int i=len-1; i>=0; i--) {//candel asel tar count kar
            if(s.charAt(i)=='|') {
                count = i;
            }
            leftSideCandles[i] = count;
        }
         int[] result = new int[queries.length];
        int k =0;
        for(int[] query : queries) {
            int left = leftSideCandles[query[0]];
            int right = rightSideCandles[query[1]];
            
             if(left != -1 && right != -1 && left < right) {
               result[k++] = Math.abs(plates[right] - plates[left]);
            }else {
               result[k++] = 0;
            }
        }
        
        return result;
    }
}