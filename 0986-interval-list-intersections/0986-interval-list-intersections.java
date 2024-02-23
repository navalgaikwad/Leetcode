class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int m = firstList.length, n = secondList.length, p = 0, q = 0;
        while (p < m && q < n) {
            if (firstList[p][0] > secondList[q][1]) {
                q++;
            } else if (firstList[p][1] < secondList[q][0]) {
                p++;
            } else {
                list.add(new int[] {Math.max(firstList[p][0], secondList[q][0]), Math.min(firstList[p][1], secondList[q][1])});
                if (firstList[p][1] < secondList[q][1]) {
                    p++;
                } else {
                    q++;
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            int[] cur = list.get(i);
            res[i][0] = cur[0];
            res[i][1] = cur[1];
        }

        return res;
    }
}