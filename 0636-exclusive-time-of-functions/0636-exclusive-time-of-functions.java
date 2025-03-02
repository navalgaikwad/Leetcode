class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for (String log : logs) {
            String[] split = log.split(":");
            int number = Integer.parseInt(split[2]);
            if (split[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += number - prev;
                }
                prev = number;
                st.push(Integer.parseInt(split[0]));
            } else {
                result[st.pop()] += number - prev + 1;
                prev = number + 1;
            }
        }
        return result;
    }
}