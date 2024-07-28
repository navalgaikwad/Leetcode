class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c :s.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}