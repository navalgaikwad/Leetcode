class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //System.out.print(map);
        List<Integer> result = new ArrayList<>();
        int counter = map.size();
        int left = 0;
        for(int right=0; right<s.length(); right++) {
            char rightSide = s.charAt(right);
            
            if(map.containsKey(rightSide)) {
                map.put(rightSide, map.getOrDefault(rightSide, 0) - 1);
                if(map.get(rightSide) == 0) {
                    counter--;
                }
            }
            
            while(counter == 0) {
                if(right - left + 1 == p.length()) {
                    result.add(left);
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
        
        return result;
    }
}

//first i will add value in the map
//then take counter = map.size();
//iterate over String s
//when ever the counter is zero
// i will add the left pointer
// and increament left until we find count grater than 0

//s = "cbaebabacd", p = "abc"
/*
a =1,0,-1,-2
b = 1,0,-1,-2
c= 1, 0, 1, 0
result = 0
left = 6
counter = 1, 0




*/