class Solution {
    public int[] asteroidCollision(int[] aste) {
        Stack<Integer> st = new Stack<>();
        int i =0; 
        while(i<aste.length) {
            boolean flag = true;
            int no;
            while(!st.isEmpty() &&  st.peek() >0 && aste[i]<0) {
                if((-aste[i]) == st.peek()) {
                    st.pop() ;
                    flag = false;
                    break;
                }else if(-aste[i] > st.peek()) {
                       st.pop() ;
            
                    //flag = false;
                }else if(-aste[i] < st.peek()){
                    flag = false;
                    break;
                }
                //i++;
            }
            if(flag) {
              st.push(aste[i]);  
            }
            i++;
    }
        int[] ans = new int[st.size()];
        int j = 0;
        for (Integer s: st) {
            ans[j++] = s;
        }
        return ans;
}
}