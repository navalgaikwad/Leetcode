class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: stones.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        System.out.print(map);
        for(char ch: jewels.toCharArray()){
            count = count + map.getOrDefault(ch, 0);
        }
        return count;
    }
}