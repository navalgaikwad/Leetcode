class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips.length == 1){
            return trips[0][0]<=capacity;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<trips.length; i++){
            map.put(trips[i][1], map.getOrDefault(trips[i][1], 0) + trips[i][0]);
            map.put(trips[i][2], map.getOrDefault(trips[i][2], 0)- trips[i][0]);
        }
        int sum =0;
        int max = 0;
        for(int value: map.values()){
            sum = sum + value;
            max = Math.max(max, sum);
        }
        if(max <= capacity){
            return true;
        }
        return false;
    }
}

//[[2,1,5],[3,3,7]]
//[1 - 2, 
//3 -3
//
//5- -2]
//7 - -3

//[[2,1,5],[3,3,7]]
// 1 - 2
// 3 - 3
// 5 - -2
// 7 - -3
//
//[[5,4,7],[7,4,8],[4,1,8]]
//17


