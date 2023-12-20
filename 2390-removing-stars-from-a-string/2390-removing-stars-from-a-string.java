class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && c == '*'){
                stack.pop();
            }else {
               stack.push(c);  
            }
        }
        if(stack.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(char c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}