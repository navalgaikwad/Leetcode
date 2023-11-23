class Solution {
    public boolean checkIfPangram(String sentence) {
        int res = 0;
        for(Character x: sentence.toCharArray()){
            int ch = x - 'a';
            int bits = 1 << ch;
            res |= bits;
        }
        return res == (1 << 26) - 1;
    }
}