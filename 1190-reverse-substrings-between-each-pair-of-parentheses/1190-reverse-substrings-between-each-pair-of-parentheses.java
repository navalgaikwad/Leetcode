class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (ch[i] == '(') {
                stack.push(i);
            } else if (ch[i] == ')') {
                int start = stack.pop();
                reverseString(ch, start + 1, i - 1);
            }
        }

        // Build the final string without the parentheses
        StringBuilder result = new StringBuilder();
        for (char c : ch) {
            if (c != '(' && c != ')') {
                result.append(c);
            }
        }
        return result.toString();
    }

    void reverseString(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

}