class Solution {
    public int romanToInt(String s) {
        int prev = Integer.MAX_VALUE;
        int total = 0;
        int len = s.length() - 1;
        //MCMXCIV
                //+5
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for(int i = len; i>=0; i--){
            char ch = s.charAt(i);
            int value = map.get(ch);
            if(prev!=Integer.MAX_VALUE && value < prev){
                total = total - value;
              
            }else{
                total = total + value;//5
            }
            prev = value;//5
        }
        return total;
    }
}

//"MCMXCIV"
//
//take prev
//set it to max
// check current value is greater than or previous
//if greater increament
// else minus it from total