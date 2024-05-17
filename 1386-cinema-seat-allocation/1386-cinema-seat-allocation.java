class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, ArrayList<Integer>> mapToSeat = new HashMap<>();
         for(int[] reservedSeat: reservedSeats) {
            if(!mapToSeat.containsKey(reservedSeat[0])) {
                mapToSeat.put(reservedSeat[0], new ArrayList<>());
            }
            mapToSeat.get(reservedSeat[0]).add(reservedSeat[1]);
        }
        
        
        int result = (n - mapToSeat.size())*2;
        for(List<Integer> map : mapToSeat.values()) {
            boolean flag = false;
            if(!map.contains(2) && !map.contains(3)&& !map.contains(4) && !map.contains(5)) {
                flag = true;
                result++;
            } 
            if(!map.contains(6) && !map.contains(7)&& !map.contains(8) && !map.contains(9)) {
                flag = true;
                result++;
            }
            if(!flag) {
                if((!map.contains(4) && !map.contains(5)&& !map.contains(6) && !map.contains(7))) {
                    result++;
                }
            }
        }
        return result;
    }
}