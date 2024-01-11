class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left =0;
        int counter = map.size();
        int len = Integer.MAX_VALUE;

        String ans = "";
        for(int right =0; right<s.length(); right++) {
           
            if(map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(map.get(s.charAt(right)) == 0) {
                    counter--;
                }
            }
            
            while(counter == 0) {
                 if (right - left < len) {
                    len = right - left ;
                    ans = s.substring(left, right + 1);
                }
                if(map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0) {
                        counter++;
                    }
                }
                left++;
            }
        }
        return ans;
    }
}