class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
       
        for(int aste : asteroids) {
            boolean flag = true;
            while(!st.isEmpty() && st.peek()>0 && aste<0) {
                if(st.peek() > -(aste)) {
                    flag = false;
                    break;
                }else if(st.peek() == -(aste)) {
                    st.pop();
                    flag = false;
                    break;
                }else if(st.peek() < -(aste)) {
                    st.pop();
                    //break;
                }
            }
            if(flag) {
              st.push(aste);  
            }
        }
        //int[] arr = arr_list.stream().mapToInt(i -> i).toArray();
        return st.stream().mapToInt(i->i).toArray();
    }
}