class Solution {
    public int[] minOperations(String boxes) {
        int count =0;
        int n = boxes.length();
        int[] res = new int[n];
        int j=0, x =0;
        for(char c : boxes.toCharArray()) {
            res[j++] = count;
            x += c  - '0';
            count+=x;
            //i++;
        }
        count = 0;
		x =0;
        for(int i=n-1; i>=0; i--) {
            res[i]+=count;
            x += boxes.charAt(i) - '0';
             count+=x;

        }
        return res;
    }
}