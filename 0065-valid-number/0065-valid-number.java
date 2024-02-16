class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        //digit seen
        //+ or - seen
        //. seen
        //e seen or digit not seen
        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                digitSeen = true;
            }else if(c == '+' || c == '-') {
                if(i > 0 && s.charAt(i - 1) != 'E' && s.charAt(i - 1) != 'e') {
                    return false;
                }
               // eSeen = true;
            }else if(c == '.') {
                if(dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            }else if(c == 'E' || c== 'e') {
                if(eSeen || !digitSeen) {
                    return false;
                }
                eSeen = true;
                digitSeen = false;
            } else {
                return false;
            }
        }

        return digitSeen;
    }
}
//+ || - asel tar pathi mghe e or E shivay dusra kon nko
//. mg dotSeen true if already bghtla mg false resutun kar
// e || E eSeen asel alerady return false
