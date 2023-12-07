
class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> charCounts = new HashMap<>();
        
      
        for(char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

      
        for(char c : t.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) - 1);
        }

        int result =0;
        for(int val : charCounts.values()) {
            if(val >=0) {
               result = result + val;  
            }
           
        }
        System.out.print(charCounts);
        return result;
    }
}
