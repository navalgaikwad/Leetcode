
class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> charCounts = new HashMap<>();
        
      // count the charatcer from s
        for(char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

      //subtract the count charcter from t
        for(char c : t.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) - 1);
        }

        int result =0;
        //add the final result
        for(int val : charCounts.values()) {
            if(val >= 0) {
               result = result + val;  
            }
           
        }
        //System.out.print(charCounts);
        return result;
    }
}
