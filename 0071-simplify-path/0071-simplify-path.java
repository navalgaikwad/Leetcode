class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> st = new Stack<>();
        for(String part: parts) {
            if(part.equals("..")) {//double dots
                if(!st.isEmpty()) {
                    st.pop();
                }
            }else if(!part.isEmpty()&&!part.equals(".")) { //single dots
                st.push(part);
            }
        }
        if(st.isEmpty())  return "/";
        StringBuilder sb = new StringBuilder();
   
         for(String s: st){
              sb.append("/"+s);
         }
             
       return sb.toString();
    }
}