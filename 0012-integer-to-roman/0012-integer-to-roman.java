import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
        LinkedHashMap<Integer, String> valuesToSymbols = new LinkedHashMap<>();
        valuesToSymbols.put(1000, "M");
        valuesToSymbols.put(900, "CM");
        valuesToSymbols.put(500, "D");
        valuesToSymbols.put(400, "CD");
        valuesToSymbols.put(100, "C");
        valuesToSymbols.put(90, "XC");
        valuesToSymbols.put(50, "L");
        valuesToSymbols.put(40, "XL");
        valuesToSymbols.put(10, "X");
        valuesToSymbols.put(9, "IX");
        valuesToSymbols.put(5, "V");
        valuesToSymbols.put(4, "IV");
        valuesToSymbols.put(1, "I");
        
        StringBuilder res = new StringBuilder();
        
        for (Map.Entry<Integer, String> entry : valuesToSymbols.entrySet()) {
            while (num >= entry.getKey()) {
                num -= entry.getKey();
                res.append(entry.getValue());
            }
        }
        
        return res.toString();
    }
}
