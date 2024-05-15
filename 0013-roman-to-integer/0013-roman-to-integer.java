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
        int prev = 0;
        int total = 0;//start from end
        for(int i=s.length() - 1; i>=0; i--) {
            int current = map.get(s.charAt(i));
            if(current < prev) {
                total = total - current;
            }else {
                total = total + current;
            }
            prev = current;
        }
        return total;
    }
}