class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack < Integer > stack = new Stack < > ();
        for (int ast: asteroids) {
            boolean isDestroyed = false;
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) { //pop(>) //dont do(<) // pop (==)
                if (-ast > stack.peek()) { //greater than ahe pop kart raha //pop kar
                    stack.pop();
                } else if (-ast < stack.peek()) {//dont add in the stack or pop
                    isDestroyed = true; // ast less than ahe tar kahi karu noko dont add in stack
                    break;
                } else if (-ast == stack.peek()) { // pop
                    stack.pop(); //equal ahet stack ani ast tar pop kar stack madhun ani destroy pan kar
                    isDestroyed = true;
                    break;
                }
            }

            if (!isDestroyed) { // not destroyed asel tar add kart raha
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