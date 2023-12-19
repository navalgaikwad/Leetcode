class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backTracking(s, 0, "", 0, result);
        return result;
    }
    void backTracking(String s, int i, String ans, int part, List<String> result) {
        int len = s.length();
        if(part == 4 || i == len) {
            if(part == 4 && i == len) {
                result.add(ans.substring(0, ans.length() - 1)); 
            }
            return;
        }
        //for single value
        backTracking(s, i + 1, ans + s.charAt(i)+".", part + 1, result);  
        if(i + 2 <= len && helper(s.substring(i, i + 2))) { //divided in 2 part size of 2 that means
            backTracking(s, i + 2, ans + s.substring(i, i + 2)+".", part + 1, result);
        }
        if(i + 3 <= len && helper(s.substring(i, i + 3))) {//divided in 3 part size of 3 that means
            backTracking(s, i + 3, ans + s.substring(i, i + 3)+".", part + 1, result);
        }  
    }
    
    
    boolean helper(String s) {
        if(s.charAt(0) == '0') return false;
        return Integer.parseInt(s) <= 255;
    }
}
//25525511135

//for single
//i + 1 : 1
//i + 2 : for 2 value
//i + 3 : for 3 value
//use string rather than stringbuilder
//ans append to s.substring
