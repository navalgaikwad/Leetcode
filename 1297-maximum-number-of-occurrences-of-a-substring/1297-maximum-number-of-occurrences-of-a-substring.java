class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i + minSize - 1 < s.length(); i++) {
            String subString = s.substring(i, i + minSize);
            map.put(subString, map.getOrDefault(subString, 0) + 1);
        }
        int res =0;
        for (Map.Entry<String,Integer> entry : map.entrySet())  {
            Set<Character> set = new HashSet<>();
            for(char c :entry.getKey().toCharArray()) {
                set.add(c);
            }
            if(set.size() <=maxLetters) {
                //res = Math.max(res,e.getValue());
                res = Math.max(res, entry.getValue());
            }
            
        }
        return res;
    }
}

// class Solution {
//     public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
//         Map<String, Integer> map = new HashMap();
        
//         int res = 0;
        
//         for (int i = 0; i + minSize - 1 < s.length(); i++) {
//             String subs = s.substring(i, i + minSize);
//             map.put(subs, map.getOrDefault(subs, 0) + 1);
//         }
        
//         for (Map.Entry<String, Integer> e : map.entrySet()) {
//             Set<Character> chrs = new HashSet();
//             for (char c : e.getKey().toCharArray()) {
//                 chrs.add(c);
//             }
            
//             if (chrs.size() <= maxLetters) {
//                 res = Math.max(res, e.getValue());
//             }
//         }
        
//         return res;
//     }
// }