class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] frq1 = new int[26];
        int[] frq2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            frq1[word1.charAt(i) - 97]++;
            frq2[word2.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            if (frq1[i] > frq2[i]){
                if (frq1[i] - frq2[i] > 3) return false;
            }else
                if (frq2[i] - frq1[i] > 3) return false;
        }
        return true;
    }
}