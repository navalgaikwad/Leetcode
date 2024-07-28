class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < len; right++){
            char input = s.charAt(right);
            map.put(input, map.getOrDefault(input, 0) + 1);
            while(map.size() > 2){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
               
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
               
            }
            System.out.print(map);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

//eceba

//e 2
//c 1
