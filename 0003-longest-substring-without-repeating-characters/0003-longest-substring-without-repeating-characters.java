class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int leftIndex = 0;
        int lengthOfWindow = 0;
        
        for(int rightIndex = 0; rightIndex <s.length(); rightIndex++) {
            
            char rightSideChar = s.charAt(rightIndex);//b
            map.put(rightSideChar, map.getOrDefault(rightSideChar, 0) + 1);//b -2
            
            while(map.get(rightSideChar) > 1) {
                char leftSideChar = s.charAt(leftIndex);//b 
                
                map.put(leftSideChar, map.getOrDefault(leftSideChar, 0) - 1);//b-1
                
                if(map.get(leftSideChar) == 0) {
                    map.remove(leftSideChar);
                }
                leftIndex++;
            }
            lengthOfWindow  =Math.max(lengthOfWindow, rightIndex - leftIndex + 1);//1
        }
        
        return lengthOfWindow;
    }
}

/*
"abcc abcbb"
        l r

"bbbbb"


"pwwkew"

a - 1 1
b - 1 2
c - 1 3
l c
a - 0
b -1
c - 1


*/