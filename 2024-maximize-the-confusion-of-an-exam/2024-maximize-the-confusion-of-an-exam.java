class Solution {
    private int count(String s, int k, char c) {
        int N = s.length(), cnt = 0, i = 0, j = 0;
        for (; j < N; ++j) {
            cnt += s.charAt(j) == c ? 1 : 0;
            if (cnt > k) cnt -= s.charAt(i++) == c ? 1 : 0;
        }
        return j - i;
    }

    public int maxConsecutiveAnswers(String s, int k) {
        return Math.max(count(s, k, 'T'), count(s, k, 'F'));
    }
}
//find for both T and F