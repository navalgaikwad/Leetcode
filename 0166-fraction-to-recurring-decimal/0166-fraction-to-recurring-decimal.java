class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb  =new StringBuilder();
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append('-');
        }
        long num = Math.abs((long)numerator);
        long demo = Math.abs((long)denominator);
        
        long q = num/demo;
        long r = num%demo;

        sb.append(q);

        if(r == 0) {
            return sb.toString();
        }
          sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while(r != 0) {
            if(map.containsKey(r)) {
                int pos = map.get(r);
                sb.insert( pos, '(');
                sb.append(')');
                break;
            }else {
                map.put(r, sb.length());
                r = r * 10;
                q = r / demo; //vvimp
                r = r % demo; //vvimp
                sb.append(q);
            }

        }
        return sb.toString();
    }
}