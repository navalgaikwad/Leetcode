class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character, Integer> map = new HashMap<>();
        int j=0;
        int len =0;
        for(int i=0; i<s.length(); i++){
          
           char r = s.charAt(i);
            map.put(r, map.getOrDefault(r,0) + 1);
            while(map.get(r) > 1){
              
                char l = s.charAt(j);
                map.put(l, map.get(l) - 1);
              
                if( map.get(s.charAt(j))==0){
                    map.remove(s.charAt(j));
                }
                j++;
            }
            
            len =  Math.max(len, i-j+1);
        }
        return len;
    }
}

// public class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         Map<Character, Integer> chars = new HashMap();

//         int left = 0;
//         int right = 0;

//         int res = 0;
//         while (right < s.length()) {
//             char r = s.charAt(right);
//             chars.put(r, chars.getOrDefault(r,0) + 1);
            
//             while (chars.get(r) > 1) {
//                 char l = s.charAt(left);
//                 chars.put(l, chars.get(l) - 1);
//                 left++;
//             }

//             res = Math.max(res, right - left + 1);

//             right++;
//         }
//         return res;
//     }
// }

