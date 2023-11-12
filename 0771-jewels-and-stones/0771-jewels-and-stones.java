class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        
        for(char jewel: jewels.toCharArray()){
            set.add(jewel);
        }
        int count = 0;
        for(char stone: stones.toCharArray()){
            //set.add(jewel);
            if(set.contains(stone)){
                count++;
            }
        }
        return count;
    }
}