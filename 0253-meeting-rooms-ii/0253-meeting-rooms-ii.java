class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] interval: intervals){
            map.put(interval[0], map.getOrDefault(interval[0], 0)+1);
            map.put(interval[1], map.getOrDefault(interval[1], 0)-1);
        }
       // System.out.print(map);
        int max = 0;
        int sum = 0;
        for(int value: map.values()) {
            sum = sum + value;
            max = Math.max(max, sum);
        }
        return max;
    }
}