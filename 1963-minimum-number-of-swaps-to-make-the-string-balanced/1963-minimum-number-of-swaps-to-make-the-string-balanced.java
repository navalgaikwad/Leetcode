class Solution {
    public int minSwaps (String s) {
        int stack_size = 0;
        for (int i = 0; i < s.length (); i++) {
            char ch = s.charAt (i);
            if (ch == '[')
                stack_size++;
            else {
                if (stack_size > 0)
                    stack_size--;
            }
        }
        return (stack_size + 1) / 2;
    }
}