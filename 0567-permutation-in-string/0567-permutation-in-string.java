class Solution {
    // abc   eidbabc
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int i = 0, j = 0;
        while(j < s2.length()) {
            char c = s2.charAt(j);
            if(map.containsKey(c)) {
                j++;
                int count = map.get(c);
                if(count == 1)
                    map.remove(c);
                else
                    map.put(c, count - 1);
            } else {
                if(i == j) {
                    i++; 
                    j++;
                } else {
                    map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
                    i++;
                }
            }    
            if(map.isEmpty())
                return true;
        }
        return false;
    }
}