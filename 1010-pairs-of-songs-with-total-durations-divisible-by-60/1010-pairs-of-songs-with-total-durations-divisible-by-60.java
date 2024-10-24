class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < time.length; i++) {
            int value = time[i] % 60;
            int complement = (60 - value) % 60; 
            
            // If complement exists in the map, it means we found a valid pair
            if (map.containsKey(complement)) {
                ans += map.get(complement);
            }
            
            // Store the count of the current remainder in the map
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        
        return ans;
    }
}

/*
30 %60 = 30
60 -30 = 30
30, 1
20 %60 = 20
60-20 = 40
40, 1
150%60 = 30 
60 -30 =30
ans =1
100 %60 = 40
60 - 40 =20
20, 1
40


*/