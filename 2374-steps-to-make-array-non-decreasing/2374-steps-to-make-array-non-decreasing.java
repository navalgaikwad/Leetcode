import java.util.Stack;

class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        Stack<int[]> st = new Stack<>(); // Stack to store {num, stepsToRemove}
        int maxSteps = 0;

        for (int i = 0; i < n; i++) {
            int steps = 0; // Steps needed to remove current element

            // Remove elements that are smaller than nums[i]
            while (!st.isEmpty() && st.peek()[0] <= nums[i]) {
                steps = Math.max(steps, st.pop()[1]); // Keep track of the max steps required
            }

            // If the stack is not empty, it means nums[i] is blocking some elements
            if (!st.isEmpty()) {
                steps += 1;
            }

            maxSteps = Math.max(maxSteps, steps);
            st.push(new int[]{nums[i], steps});
        }

        return maxSteps;
    }
}
