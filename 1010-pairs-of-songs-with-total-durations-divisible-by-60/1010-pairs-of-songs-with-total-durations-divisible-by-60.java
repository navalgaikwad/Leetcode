class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length, ans = 0;
        HashMap<Integer, Integer> len = new HashMap<>();
        for(int i  = 0; i < n; i++){
            int rem = time[i] % 60;
            int target = 60 - (rem);
            if(len.containsKey(target))
                ans += len.get(target);
            if(rem != 0)
                len.put(rem, len.getOrDefault(rem, 0) + 1);
            else
                len.put(60, len.getOrDefault(60, 0) + 1);
        }
        return ans;
    }
}