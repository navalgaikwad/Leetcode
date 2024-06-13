public class Solution {

    
    class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int sumSubarrayMins(int[] arr) {
        final int MOD = (int) 1e9 + 7;
        int n = arr.length;
        long res = 0;
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&  stack.peek().value> arr[i]) {
                Pair popped = stack.pop();
                int j = popped.index;
                int m = popped.value;
                int left = j - (stack.isEmpty() ? -1 : stack.peek().index);
                int right = i - j;
                res = (res + (long) m * left * right) % MOD;
            }
            stack.push(new Pair(i, arr[i]));
        }

        while (!stack.isEmpty()) {
            Pair popped = stack.pop();
            int j = popped.index;
            int m = popped.value;
            int left = j - (stack.isEmpty() ? -1 : stack.peek().index);
            int right = n - j;
            res = (res + (long) m * left * right) % MOD;
        }
        return (int) res;
    }
}
