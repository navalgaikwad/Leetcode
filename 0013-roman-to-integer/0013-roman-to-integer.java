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
        int len = s.length();
        int prev =0;
        int total =0;
        for(int i = len - 1; i>=0; i-- ) {
            int value = map.get(s.charAt(i));
            if(value < prev) {
                total-=value;
            }else {
                total+=value;
            }
            prev = value;
        }
        return total;
    }
}