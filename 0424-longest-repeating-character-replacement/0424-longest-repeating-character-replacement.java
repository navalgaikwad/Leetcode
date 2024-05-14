class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int leftSide =0;
        int len = 0;
        int frequency =0;
        for(int right=0; right<s.length(); right++) {
            char rightSideChar = s.charAt(right);
            
            map.put(rightSideChar, map.getOrDefault(rightSideChar, 0) + 1);
            frequency = Math.max(frequency, map.get(rightSideChar));
            int replacement = (right - leftSide + 1) -  frequency;
            
            if(replacement > k) {
                char leftSideChar = s.charAt(leftSide);
                map.put(leftSideChar, map.getOrDefault(leftSideChar, 0) - 1);
                leftSide++;
            }
            len = Math.max(len, right - leftSide + 1);
        }
        return len;
    }
}
// class Solution {
//     public int characterReplacement(String s, int k) {
//         Map<Character, Integer> map = new HashMap<>();
//         int left =0;
//         int len = 0;
//         int freq =0;
//         for(int right =0; right < s.length(); right++) {
//             char rightChar = s.charAt(right);
//             map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
//             freq =Math.max(freq, map.get(rightChar));
//             int replacement = (right - left  +1) - freq;
//             if(replacement > k) {
//                 char leftChar = s.charAt(left);
//                 map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
//                 left++;
//             }
            
//             len = Math.max(len, right - left  +1);
//         }
//         return len;
//     }
// }