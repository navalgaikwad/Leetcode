class Solution {
    public int romanToInt(String s) {
        int prev =0;
        int total = 0;
        int len = s.length() - 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for(int i = len; i>=0; i--){
           int value =  map.get(s.charAt(i));
            if(value < prev){
                total = total - value;
            }else{
               total = total + value;
           }
            prev = value;
        }
        return total;
    }
}