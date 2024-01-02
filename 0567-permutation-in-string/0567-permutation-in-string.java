class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int k = s1.length();
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        s1 = String.valueOf(chars);
        for(int right =0; right<=s2.length() - k; right++) {
            String substring = s2.substring(left, right + k);
            char[] c = substring.toCharArray();
            Arrays.sort(c);
            String str = String.valueOf(c);
            if(s1.equals(str)) {
                return true;
            }
            left++;
        }
        
        return false;
    }
}