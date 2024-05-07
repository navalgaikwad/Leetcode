class Solution {
public int numberOfSubstrings(String s) {
//use a dynamic sliding window with aux DS
Map<Character, Integer> charFreqMap = new HashMap<>();
int numSubstrings = 0;
int leftWindowIdx = 0;
//basic window algorithm set up
for(int rightWindowIdx = 0; rightWindowIdx < s.length(); rightWindowIdx++){
//increase the window size
char rightChar = s.charAt(rightWindowIdx);
//add the freq of a,b,c
charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
//if a,b,c freq are all >= 1 we can reduce the window until we break OG condition
while(charFreqMap.size() >= 3){
//close window and decrease char count for left-most char
char leftChar = s.charAt(leftWindowIdx);
charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
//don't forget to remove any empty char count
if(charFreqMap.get(leftChar) == 0){
charFreqMap.remove(leftChar);
}
//close window
leftWindowIdx++;
}
//each idx after closing will be equal to the number of substrings after this idx
numSubstrings += leftWindowIdx;
}
return numSubstrings;
}
}