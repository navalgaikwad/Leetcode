class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] v1 = new int[26];
        int[] v2 = new int[26];
        int[] v1Visited = new int[26];
        int[] v2Visited = new int[26];
        for(char c: word1.toCharArray()) {
            v1[c- 'a']++;
            v1Visited[c-'a'] = 1;
        }
        for(char c: word2.toCharArray()) {
            v2[c- 'a']++;
            v2Visited[c-'a'] = 1;
        }
        Arrays.sort(v1);
        Arrays.sort(v2);
        
        return Arrays.equals(v1, v2) && Arrays.equals(v1Visited, v2Visited);
    }
}