class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int left = 0;
        List<Integer> result = new ArrayList<>();
        for(int right = 0; right <= s.length() - k; right++) {
            String sub = s.substring(left, right + k);
            if(checkAnagram(sub, p)) {
                result.add(left);
            }
            left++;
        }
        return result;
    }
    
    boolean checkAnagram(String sub, String p) {
        // Frequency arrays for comparison
        int[] subCount = new int[26];
        int[] pCount = new int[26];

        // Populate the frequency arrays
        for (int i = 0; i < sub.length(); i++) {
            subCount[sub.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        // Compare the frequency arrays
        for (int i = 0; i < 26; i++) {
            if (subCount[i] != pCount[i]) {
                return false;
            }
        }
        return true;
    }
}
