class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40,  10,9, 5,4, 1};
        
        String[] notation = {"M",  "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<values.length; i++) {
            while(num >= values[i]) {
                num-=values[i];
                sb.append(notation[i]);
            }

        }
        return sb.toString();
    }
}

 // valuesToSymbols.put(1000, "M", );
 //        valuesToSymbols.put(900, "CM");
 //        valuesToSymbols.put(500, "D");
 //        valuesToSymbols.put(400, "CD");
 //        valuesToSymbols.put(100, "C");
 //        valuesToSymbols.put(90, "XC");
 //        valuesToSymbols.put(50, "L");
 //        valuesToSymbols.put(40, "XL");
 //        valuesToSymbols.put(10, "X");
 //        valuesToSymbols.put(9, "IX");
 //        valuesToSymbols.put(5, "V");
 //        valuesToSymbols.put(4, "IV");
 //        valuesToSymbols.put(1, "I");