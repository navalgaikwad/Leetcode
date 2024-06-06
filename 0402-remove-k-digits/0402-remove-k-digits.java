class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack=new LinkedList<>();

        for(Character c:num.toCharArray()){
            while(!stack.isEmpty() && stack.peek()>c && k>0){
                stack.pop();
                k--;
            }
            stack.push(c);     
        }
        //System.out.print(stack);
        while(!stack.isEmpty() && stack.peekLast()=='0'){
            stack.pollLast();
        }

        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder result=new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pollLast());
        }
        return result.isEmpty()?"0":result.toString();
    }
}
