class Solution {
    public String findLatestTime(String s) {
        char h1 = s.charAt(0);
        char h2 = s.charAt(1);
        char m1 = s.charAt(3);
        char m2 = s.charAt(4);

        StringBuilder sb = new StringBuilder();

        if(h1 == '?' && h2 == '?') sb.append("11");//both are question mark
        else if(h1 == '?' && h2 >= '2') sb.append("0").append(h2); //h1 is ? but h2 is >=2
        else if(h1 == '?' && h2 < '2') sb.append("1").append(h2);//h1 is ? but h2<2 10
        else if(h1 == '0' && h2 == '?') sb.append(h1).append("9");//if first is 0 and h2 is 9
        else if(h1 == '1' && h2 == '?') sb.append(h1).append("1");
        else sb.append(h1).append(h2);//??01

        sb.append(":");

        if(m1 == '?' && m2 == '?') sb.append("59");
        else if(m1 == '?') sb.append("5").append(m2); //5?
        else if(m2 == '?') sb.append(m1).append("9");//?9
        else sb.append(m1).append(m2);

        return sb.toString();
    }
}