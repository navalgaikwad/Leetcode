class Solution {
    public String simplifyPath(String path) {
        Stack<String> s= new Stack<>();
        String[] arr = path.split("/");
        for(String a : arr) {
            if(a.equals("..")) {
                if(!s.isEmpty()) {
                    s.pop();
                }
            } else if( !a.equals(".") && !a.isEmpty()) {//.ani empty
                s.push(a);
            }
        }
        if(s.isEmpty())  return "/";
        StringBuilder st  = new StringBuilder();
            for(String sb:s) {
                st.append("/"+sb);
            }
            return st.toString();
    }
}

/*


home

naval

..

1.sepearate by /
2. when i find .. remove from stack



*/