class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left =0;
        int counter = map.size();
        ArrayList<Integer> ans = new ArrayList<>(); 
        for(int right =0; right<s.length(); right++) {
            char rightSide = s.charAt(right);
            if(map.containsKey(rightSide)) {
                map.put(rightSide, map.getOrDefault(rightSide, 0) - 1);
                if(map.get(rightSide) == 0) {
                    counter--;
                }
            }
            while(counter == 0) {
                if(right - left + 1 == p.length()) {
                    ans.add(left);
                }
                char leftSide = s.charAt(left);
                if(map.containsKey(leftSide)) {
                    map.put(leftSide, map.getOrDefault(leftSide, 0) + 1);
                    if(map.get(leftSide) > 0) {
                        counter++;
                    }
                }
                left++;
            }
        }
        return ans;
    }
}