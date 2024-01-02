class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int a_count =0;
        int b_count =0;
        int c_count =0;
        int total = a+b+c;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<total; i++) {
            if( (a>=b && a>=c && a_count < 2) || (b_count==2 & a > 0) || (c_count==2 && a > 0)) {
                sb.append("a");
                a_count++;
                a--;
                b_count=0;
                c_count=0;
            }else if( (b>=a && b>=c && b_count < 2) || (a_count==2 & b > 0) || (c_count==2 && b > 0)) {
                sb.append("b");
                b_count++;
                b--;
                a_count=0;
                c_count=0;
            }else if( (c>=a && c>=b && c_count < 2) || (a_count==2 & c > 0) || (b_count==2 && c > 0)) {
                sb.append("c");
                c_count++;
                c--;
                b_count=0;
                a_count=0;
            }
        }
        return sb.toString();
    }
}