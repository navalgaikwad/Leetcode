class Solution {
public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
int result = 0;
Map<Integer, List<Integer>> seatAllocation = new HashMap<>();
for(int[] reservedSeat : reservedSeats) {
if(seatAllocation.containsKey(reservedSeat[0])) {
seatAllocation.get(reservedSeat[0]).add(reservedSeat[1]);
}else {
seatAllocation.put(reservedSeat[0],  new ArrayList<>());
seatAllocation.get(reservedSeat[0]).add(reservedSeat[1]);
}
}
result = (n - seatAllocation.size())*2;
for(List<Integer> rowToSeat:seatAllocation.values()) {
boolean flag = false;
if(!rowToSeat.contains(2)&& !rowToSeat.contains(3)
&& !rowToSeat.contains(4) && !rowToSeat.contains(5)) {
result++;
flag = true;
}
if(!rowToSeat.contains(6)&& !rowToSeat.contains(7)
&& !rowToSeat.contains(8) && !rowToSeat.contains(9)) {
result++;
flag = true;
}
if(!flag) {
if(!rowToSeat.contains(4)&& !rowToSeat.contains(5)
&& !rowToSeat.contains(6) && !rowToSeat.contains(7)) {
result++;
}
}
}
return result;
}
}