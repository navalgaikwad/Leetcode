class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int[] reservedSeat: reservedSeats) {
            if(!map.containsKey(reservedSeat[0])) {
                map.put(reservedSeat[0], new ArrayList<>());
            }
            map.get(reservedSeat[0]).add(reservedSeat[1]);
        }
        
        int result = (n - map.size()) * 2;
        
        for(List<Integer> rowToSeat:map.values()) {
            boolean flag = false;
            if(!rowToSeat.contains(2)&& !rowToSeat.contains(3) && !rowToSeat.contains(4) && !rowToSeat.contains(5)) {
                flag = true;
                result++;
            } 
            if(!rowToSeat.contains(6)&& !rowToSeat.contains(7) && !rowToSeat.contains(8) && !rowToSeat.contains(9)) {
                flag = true;
                result++;
            }
            if(!flag) {
               if(!rowToSeat.contains(4)&& !rowToSeat.contains(5) && !rowToSeat.contains(6) && !rowToSeat.contains(7)) {
                   result++;
               } 
            }
        }
        return result;
    }
}