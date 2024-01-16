class Solution {
    public int maxDepth(String s) {
        int currDept = 0;
        int maxDept =0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                currDept++;
                maxDept = Math.max(maxDept, currDept);
            }else {
                if(c == ')') {
                   currDept--; 
                }
            }
        }
        return maxDept;
    }
}