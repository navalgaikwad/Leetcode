LinkedList<int[]> mergedList = new LinkedList<>();
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
for(int[]  interval: intervals){
if(mergedList.isEmpty() || mergedList.getLast()[1] < interval[0]){
mergedList.add(interval);
}else if(interval[0] <= mergedList.getLast()[1]){
mergedList.getLast()[1] =  Math.max(interval[1], mergedList.getLast()[1]);
//take max from intervals
}
}
int[][] result = new int[mergedList.size()][2];
int i = 0;
for (int[] interval : mergedList){
result[i] = interval;
i += 1;
}
return result;