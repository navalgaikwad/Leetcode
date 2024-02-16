class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i =0; int j=0;
        while(i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            int a_start = first[0];  int b_start = second[0];
            int a_end = first[1];    int b_end = second[1];
            if(a_start <= b_end && b_start<=a_end) {
                  result.add(new int[]{Math.max(a_start, b_start), Math.min(a_end, b_end)});
            }
            if(a_end <= b_end) {
                i++;
            }else {
                j++;
            }
        }
        //return ans.stream().map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        //return ans;
        return result.toArray(new int[result.size()][]);
    }
}

//firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
//a.start < b.end and b.start < a.end
//max(a.start, b.start), min(a.end, b.end)
//a.end <=b.end
 //i++;
//or j++