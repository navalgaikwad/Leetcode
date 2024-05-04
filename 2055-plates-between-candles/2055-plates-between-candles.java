class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int length = s.length();
        int[] plate = new int[length];
        int[] leftSide = new int[length];
        int[] rightSide = new int[length];
        
        int count = 0;
        //count plates
        for(int i=0; i<length; i++) {
            if(s.charAt(i) == '*') {
                count++;
            }
            plate[i] = count;
        }
        //now catch the index
        count = -1;
        for(int i=0; i<length; i++) {
            if(s.charAt(i) == '|') {
                count = i;
            }
            rightSide[i] = count;
        }
        count = -1;
        for(int i = length-1; i >= 0; i--) {
            if(s.charAt(i) == '|') {
                count = i;
            }
            leftSide[i] = count;
        }
        
        int[] result = new int[queries.length];
        int i =0;
        for(int[] querie:queries) {
            int left = leftSide[querie[0]];
            int right = rightSide[querie[1]];
            
            if(left !=-1 && right !=-1 && left < right) {
                result[i++] = Math.abs(plate[right] - plate[left]);
            }else {
                result[i++] = 0;
            }
        }
        return result;
    }
}