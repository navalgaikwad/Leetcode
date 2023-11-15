class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //just like two sum
        for (int t : time) {
            int remainder = t % 60;
            int complement = (60 - remainder) % 60;

            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
// 1st element (t = 30):
// remainder = 30 % 60 = 30
// complement = (60 - 30) % 60 = 30
// map = {30: 1}
// 2nd element (t = 20):
// remainder = 20 % 60 = 20
// complement = (60 - 20) % 60 = 40
// No complement found in the map.
// map = {30: 1, 20: 1}
// 3rd element (t = 150):
// remainder = 150 % 60 = 30
// complement = (60 - 30) % 60 = 30
// Complement found in the map for remainder = 30.