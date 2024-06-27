class Solution {
    private int count(String s, int k, char c) {
        int N = s.length(), cnt = 0;
        int left = 0;
        int right = 0;
        for (; right < N; ++right) {
            cnt += s.charAt(right) == c ? 1 : 0;
            if (cnt > k) cnt -= s.charAt(left++) == c ? 1 : 0;
        }
        return right - left;
    }

    public int maxConsecutiveAnswers(String s, int k) {
        return Math.max(count(s, k, 'T'), count(s, k, 'F'));
    }
}
//find for both T and F