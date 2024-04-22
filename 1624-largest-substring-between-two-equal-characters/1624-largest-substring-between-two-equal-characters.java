class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = -1;
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                maxLength = Math.max(maxLength, i - map.get(s.charAt(i)) - 1);
            }else {
                map.put(s.charAt(i), i);
            }
        }
        return maxLength;
    }
}

/*
a - 0
b -1
c- 2
a - 3
3-0-1

*/