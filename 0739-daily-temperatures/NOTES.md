class Solution {
public int[] dailyTemperatures(int[] temperatures) {
Stack<Integer> st = new Stack<>();
int len = temperatures.length;
int[] result = new int[len];
for(int i=0; i<len; i++) {
while(!st.isEmpty()&& temperatures[st.peek()] < temperatures[i]) {
int index = st.pop();
result[index] = i - index;//after how many day that is index - i
}
st.push(i);
}
return result;
}
}