class Solution {
       public int minFlips(String target) {
        int cnt = 0, state = 0;
        for (var b : target.toCharArray())
            if (b - '0' != state) {
                state = b - '0';
                ++cnt;
            }
        return cnt;
    }
}