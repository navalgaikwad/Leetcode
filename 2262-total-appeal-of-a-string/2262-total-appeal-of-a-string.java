class Solution {
    public long appealSum(String s) {
        int[] counts = new int[26];
        long result = 0;
        for(int i=0; i<s.length(); i++) {
            counts[s.charAt(i) -'a'] = i + 1;
            for(int count:counts) {
                result+=count;
            }
        }
        return result;
    }
}