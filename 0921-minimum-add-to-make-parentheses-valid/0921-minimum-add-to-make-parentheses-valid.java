class Solution {
     public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int moves = 0;
        for(char c : chars){
            if(c == '('){
                stack.push('(');
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    moves++;
                }
            }
        }
        return moves + stack.size();
    }
}
//for ( add into the stack
//if stack is not empty pop the element
//other wise increment pointer