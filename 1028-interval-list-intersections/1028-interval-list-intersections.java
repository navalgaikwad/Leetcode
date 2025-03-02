class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;
        int j=0;
        List<int[]>result = new ArrayList<>();
        while(i < firstList.length && j < secondList.length) {
            int first = Math.max(firstList[i][0], secondList[j][0]);
            int second = Math.min(firstList[i][1], secondList[j][1]);
            if(first <= second) {
                result.add(new int[]{first, second});
            }
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            }else {
                j++;
            }

        }
        return result.toArray(new int[result.size()][]);
    }
}