class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int x: nums) sb.append(x);
        String str = sb.toString();
        int[] res = new int[str.length()];
        for(int i=0;i<res.length;i++){
            res[i] = str.charAt(i)-'0';
        }
        return res;
    }
}