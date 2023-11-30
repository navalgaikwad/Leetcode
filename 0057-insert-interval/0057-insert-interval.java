class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> mergedList = new ArrayList<>();
        for(int i =0; i<intervals.length; i++) {
            if(newInterval[1] < intervals[i][0]) {//if it at start
                mergedList.add(newInterval);
                // Collections.addAll(mergedList, intervals.subList(i, intervals.length));
                 Collections.addAll(mergedList, Arrays.copyOfRange(intervals, i, intervals.length));
                 return mergedList.toArray(new int[mergedList.size()][]); 
            }else if(intervals[i][1] < newInterval[0]) { //in middle
                mergedList.add(intervals[i]);
            } else { //overlapping 
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        mergedList.add(newInterval);
        return mergedList.toArray(new int[mergedList.size()][]);  
    }
}