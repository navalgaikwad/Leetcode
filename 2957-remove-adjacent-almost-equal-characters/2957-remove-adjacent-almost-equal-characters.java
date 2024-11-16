class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int cnt = 0;

        for (int i = 1; i < word.length();) {
            char prev = word.charAt(i-1);
            char curr = word.charAt(i);
            if (Math.abs(curr - prev) <= 1) {
                cnt++;
                ++i; //goes inside increamnet 2 time
            }
            ++i;
        }
        return cnt;
    }
}