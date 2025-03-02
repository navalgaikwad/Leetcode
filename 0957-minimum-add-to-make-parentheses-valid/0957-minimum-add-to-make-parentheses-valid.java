class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        int count =0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                balance++;
            }else {
                if(balance > 0) {
                    sb.append("(");
                    balance--;
                }else {
                    count++;
                }
            }
            sb.append(c);
        }
        int val = balance;
        while (val-- > 0) {
            sb.append(')');
        }
        System.out.print(sb.toString());
        return count + balance;
        
    }
}