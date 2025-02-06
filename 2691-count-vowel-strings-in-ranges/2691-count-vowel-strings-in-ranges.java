class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] prefix = new int[n+1];
        for(int i = 0; i < n; i++) {
            String word = words[i];
            prefix[i + 1] = prefix[i];
            if(vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                prefix[i + 1]++;
            }
        }
        int[] result = new int[queries.length];
        int i =0;
        for(int[] querie:queries) {
            result[i++] = prefix[querie[1] + 1]  - prefix[querie[0]];
        }
        return result;
    }
}