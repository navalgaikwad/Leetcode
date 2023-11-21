class Solution {
    public int minSteps(String s, String t) {
        //take map find count
        //if count ==0 from map than increase the result
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        for(char ch: t.toCharArray()){
            
            if(map.getOrDefault(ch, 0) <= 0){
                count++;
            }
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        return count;
    }
}