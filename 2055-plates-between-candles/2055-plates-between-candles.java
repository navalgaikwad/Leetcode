class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] leftSideCandles = new int[len];
        int[] rightSideCandles = new int[len];
        int[] plates = new int[len];
        
        int count =0;
        int index =0;
        for(char c : s.toCharArray()) {
            if(c == '*') {
                count++;
            }
            plates[index++] = count;
        }
        count =-1;
        for(int i=len-1; i>=0; i--) {
            if(s.charAt(i) == '|') {
                count = i;
            }
            leftSideCandles[i] = count;//start from end
        }
        count =-1;
        for(int i=0; i <len; i++) {
            if(s.charAt(i) == '|') {
                count = i;
            }
            rightSideCandles[i] = count;//start from right
        }
        int[] result = new int[queries.length];
        index =0;
        for(int[] querie : queries) {
            
            int left = leftSideCandles[querie[0]];
            int right = rightSideCandles[querie[1]];
            if(left != -1 && right != -1 && left < right) {
                result[index++] =  Math.abs(plates[right] - plates[left]);
            }else {
                result[index++] = 0;
            }
        }
        return result;
    }
}