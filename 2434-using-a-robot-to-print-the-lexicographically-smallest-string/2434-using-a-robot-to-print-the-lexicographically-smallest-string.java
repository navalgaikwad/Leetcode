import java.util.Stack;

public class Solution {
    public String robotWithString(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            stack.push(ch);
            frequency[ch - 'a']--;

            while (!stack.isEmpty() && isSmallestCharacter(stack.peek(), frequency)) {
                result.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private boolean isSmallestCharacter(char ch, int[] frequency) {
        for (char c = 'a'; c < ch; c++) {
            if (frequency[c - 'a'] > 0) {
                return false;
            }
        }
        return true;
    }
}
