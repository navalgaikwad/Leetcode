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
        int total = 0;
        int len = s.length()-1;
        //IV
        int result = 0;
        for(int i = len; i>=0; i-- ) {
            char c = s.charAt(i);
            int amount = map.get(c);
            if(prev!=0 && amount < prev) {
                total = total - amount;
            }else {
                total = total + amount;;
            }
            prev = amount;
        }
        return total;
    }
}
//"III"