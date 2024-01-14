class Solution {
    public int maxVowels(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left =0;
        int counter =0;
        int len =0;
        for(int right =0; right <s.length(); right++) {
            if(isValid(s.charAt(right))) {
                counter++;
            }
            while(right - left + 1 > k) {//right -left + 1 to length type question
                if(isValid(s.charAt(left))) {
                    counter--;
                }
                left++;
            }
            len = Math.max(counter, len);
        }
        return len;
    }
    boolean isValid(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c=='o' || c == 'u';
    }
}