class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, "", 0);
        return max;
    }
    
    void dfs(List<String> arr, String current, int curr) {
        if(current.length() > max) {
            max = current.length();
       
        }
        for(int index =curr; index <arr.size(); index++) {
            if(!isValid(current, arr.get(index))) {
                continue;
            }
            dfs(arr, current+arr.get(index), index + 1);
        }
    }
    
    boolean isValid(String current, String newString) {
        int[] count = new int[26];
        for(int i=0; i<newString.length(); i++) {
            ++count[newString.charAt(i)-'a'];
            if(count[newString.charAt(i)-'a'] == 2) {//char count
                return false;
            }
            if(current.contains(newString.charAt(i)+"")) {//Find out if a string contains a sequence of characters: 
                return false;
            }
        }
        return true;
    }
    
}