class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
            for(int ast :asteroids){
               boolean isFlag = false;
                while(!stack.isEmpty() && ast<0 && stack.peek()>0) {
                  if(-ast > stack.peek()) {
                       stack.pop();

                     } else if(stack.peek() >= -ast) {
                        isFlag = true;
                        if( -ast == stack.peek()){
                            stack.pop();
                        }
                        break;
                    } 
                  }
        
                 if(!isFlag){
                   stack.push(ast);     
                 }
            }
    
        int[] ans = new int[stack.size()];
        int i=0;
        for(Integer st: stack){
            ans[i++] = st;
        }
       return ans; 
    }
}

