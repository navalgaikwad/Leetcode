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