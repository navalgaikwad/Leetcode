class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0 && a.charAt(p1) == '1') {
                carry += 1;
            }
            
            if (p2 >= 0 && b.charAt(p2) == '1') {
                carry += 1;
            }
            
            if (carry % 2 == 1) {
                result.append('1');
            } else {
                result.append('0');
            }
            
            carry /= 2;
            p1--;
            p2--;
        }
        
        if (carry == 1) {
            result.append('1');
        }

        return result.reverse().toString();
    }
}
