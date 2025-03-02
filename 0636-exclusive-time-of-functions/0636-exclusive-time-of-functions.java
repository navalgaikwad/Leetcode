class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
         int prev = 0;
        for(String log : logs) {
            String[] split = log.split(":");
            if(split[1].equals("start")) {
                if(!st.isEmpty()) {
                    result[st.peek()]+= Integer.parseInt(split[2]) - prev;
                }

                st.push(Integer.parseInt(split[0]));
                prev = Integer.parseInt(split[2]);
            }else {
                result[st.pop()]+= Integer.parseInt(split[2]) - prev + 1;
                prev = Integer.parseInt(split[2])+1;
            }
        }
        return result;
    }
}