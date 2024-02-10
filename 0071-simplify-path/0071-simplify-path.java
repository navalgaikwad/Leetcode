class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> s = new Stack<>();
        for(String a : arr) {
            if(a.equals("..")) {
                if(!s.isEmpty() || s.equals("")) {
                    s.pop();
                }
            }else {
                if( !a.equals(".") && !a.isEmpty()) s.push(a);
            }
        }
        ///System.out.print(s);
        if(s.isEmpty())  return "/";
        StringBuilder sb= new StringBuilder();
        for(String st:s) {
                sb.append("/"+st);
            }
        return sb.toString();
    }
}

// /home/../ -> home .. 
//
