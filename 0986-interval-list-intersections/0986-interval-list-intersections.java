class Solution {
    public int[][] intervalIntersection(int[][] fl, int[][] sl) {
        int i =0;
        int j=0;
        List<int[]> result = new ArrayList<>();
        while( i< fl.length && j < sl.length) {
            int flStart = fl[i][0];
            int flEnd = fl[i][1];
            int slStart = sl[j][0];
            int slEnd = sl[j][1];
            
            if(flStart <=slEnd && slStart<=flEnd) {
                int max = Math.max(flStart, slStart);
                int min = Math.min(slEnd, flEnd);
                result.add(new int[]{max, min});
            }
            
            if(flEnd <= slEnd) {
                i++;
            }else {
                j++;
            }
        }
       return result.toArray(new int[result.size()][]);
    }
}