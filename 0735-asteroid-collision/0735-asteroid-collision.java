class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack < Integer > stack = new Stack < > ();
        for (int ast: asteroids) {
            boolean isDestroyed = false;
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop();
                } else if (-ast <= stack.peek()) {
                    isDestroyed = true;
                    if (-ast == stack.peek()) {
                        stack.pop();
                    }
                    break;
                }
            }

            if (!isDestroyed) {
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        int i = 0;
        for (Integer st: stack) {
            ans[i++] = st;
        }
        
        
        return ans;
    }
    
}