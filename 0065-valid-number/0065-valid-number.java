class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean eseen = false;
        boolean digit = false;
        boolean dotSeen = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digit = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'E' && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else if (c == '.') {
                if (dotSeen || eseen) { //de
                    return false;
                }
                dotSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eseen || !digit) {//edi
                    return false;
                }
                eseen = true;
                digit = false;
            } else {
                return false;
            }
        }

        return digit;
    }
}