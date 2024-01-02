class Solution {
    public boolean checkInclusion(String s1, String s2) {
       Map<Character, Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
         while(right < s2.length()) {
            char c = s2.charAt(right);
            if(map.containsKey(c)) {
                right++;
                int count = map.get(c);
                if(count == 1)
                    map.remove(c);
                else {
                    map.put(c, count - 1);
                }
            }else {
                if( left == right) {
                    left++;
                    right++;
                }else {// to make j equal to i 
                    map.put(s2.charAt(left), map.getOrDefault(s2.charAt(left), 0) + 1);
                    left++;
                }
            }
            if(map.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}