import java.util.ArrayList;
import java.util.List;

public class Solution {
            // Backtracking helper method.
        List<String> ipAddresses = new ArrayList<>();
     java.util.function.Function<String, Boolean> isValid = (octet) -> 
                !(octet.charAt(0) == '0' && octet.length() > 1) && Integer.parseInt(octet) <= 255;

        void backtrack(String s, List<String> current, int index) {
            if (current.size() > 4) {
                return;
            }

            if (index == s.length() && current.size() == 4) {
                ipAddresses.add(String.join(".", current));
                return;
            }

            for (int i = 1; i <= 3; i++) {
                if (index + i <= s.length()) {
                    String octet = s.substring(index, index + i);
                    if (isValid.apply(octet)) {
                        current.add(octet);
                        backtrack(s, current, index + i);
                        current.remove(current.size() - 1);
                    }
                }
            }
        }
    public List<String> restoreIpAddresses(String s) {
    
        // Start the backtracking process.
        backtrack(s, new ArrayList<>(), 0);
        return ipAddresses;
    }
}
