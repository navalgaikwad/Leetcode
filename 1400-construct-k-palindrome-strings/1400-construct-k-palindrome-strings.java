class Solution {
    public boolean canConstruct(String s, int k) {
        int[] arr = new int[26];
        int n=s.length();
        if( k > n ) return false;
        for(char c : s.toCharArray()) {
            arr[c-'a']++;
        }
        int res =0;
        for(int i=0;i<26;i++) {
            if(arr[i]%2!=0) {
                res++;
            }
        }
        return res <=k;
    }
}
//count odd occurences of character, here it is 'b' in annabelle for k = 2