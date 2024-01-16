class Solution {
    
    boolean solve(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i =0; i< s1.length(); i++) {
            if(arr1[i] > arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkIfCanBreak(String s1, String s2) {
        return solve(s1, s2) || solve(s2, s1);
    }
}
//sort it
//then check it in description s1[i] > s2[i] return false