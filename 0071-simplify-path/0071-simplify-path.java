class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");
        for(String arr : array) {
            if(arr.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }else if(!arr.isEmpty() && !arr.equals(".")) {
                stack.push(arr);
            }
        }
        //System.out.print(stack);
        if(stack.isEmpty())  return "/";
        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }
}