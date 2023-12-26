import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        String[] arr = s.trim().split("\\s+"); //remove trailing space : \\s+
        for (String a : arr) {
            st.push(a);
        }

        StringBuilder result = new StringBuilder();
        while (st.size()>1) {
            result.append(st.pop().trim());
            result.append(" ");
        }
        result.append(st.pop());
        return result.toString();
    }
}
