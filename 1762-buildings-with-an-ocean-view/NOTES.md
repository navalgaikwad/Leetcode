class Solution {
public int[] findBuildings(int[] heights) {
Stack<Integer> st = new Stack<>();
for(int i =0; i<heights.length; i++) {
while(!st.isEmpty() && heights[st.peek()] <= heights[i]) {
st.pop();
}
st.push(i);
}
int[] array = new int[st.size()];
int i=0;
for(Integer s : st) {
array[i++] = s;
}
return array;
}
}