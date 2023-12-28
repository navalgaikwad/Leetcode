class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length() -1;
        int prev = Integer.MAX_VALUE;
        int result =0;
        for(int i = len; i>=0; i--) {
            int value  = map.get(s.charAt(i));
            if(prev!=Integer.MAX_VALUE && value < prev) {
                result = result - value;
            }else {
                result = result + value;
            }
            prev = value;
        }
        return result;
    }
}