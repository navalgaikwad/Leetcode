class Solution {
    public String decodeString(String s) {
        Stack<Integer> stCount = new Stack<>();
        Stack<String> result = new Stack<>();
        int len = s.length();
        int i = 0;
        String res = "";
        while (i < len) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while(Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                stCount.push(count);
            } else if (s.charAt(i) == '[') {
                result.push(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(result.pop());
                int val = stCount.pop();
                while (val > 0) {
                    sb.append(res);
                    val--;
                }
                res = sb.toString();
                i++;
            } else {
                res = res + s.charAt(i);
                i++;
            }
        }
        return res;
    }
}
