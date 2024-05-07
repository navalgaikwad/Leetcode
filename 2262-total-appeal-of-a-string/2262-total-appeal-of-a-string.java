class Solution {
    public long appealSum(String s) {
        int[] lists = new int[26];
        long result = 0;
        for(int i=0; i<s.length(); ++i) {
            lists[s.charAt(i) - 'a']= i + 1;
            for(int list : lists) {
                result+=list;
            }
        }
        return result;
    }
}


 // public long appealSum(String s) {
 //        int last[] = new int[26];
 //        long res = 0;
 //        for (int i = 0; i < s.length(); ++i) {
 //            last[s.charAt(i) - 'a'] = i + 1;
 //            for (int j: last)
 //                res += j;
 //        }
 //        return res;
 //    }