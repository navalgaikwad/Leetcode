class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();
        int len1 = firstList.length;
        int len2 = secondList.length;
        int i = 0, j =0;
        while( i< len1 && j < len2) {
            int low =Math.max(firstList[i][0], secondList[j][0]);
            int high =Math.min(firstList[i][1], secondList[j][1]);
            
            if(low <= high) {
                list.add(new int[]{low, high});
            }
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            }else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}