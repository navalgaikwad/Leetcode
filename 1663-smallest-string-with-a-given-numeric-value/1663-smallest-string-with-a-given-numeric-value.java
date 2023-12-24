class Solution {
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        Arrays.fill(result, 'a');
        k = k - n;
        while(k > 0) {
            n--;
            result[n] += Math.min(25, k);
            k = k - Math.min(25, k);
        }
        return String.valueOf(result);
    }
}