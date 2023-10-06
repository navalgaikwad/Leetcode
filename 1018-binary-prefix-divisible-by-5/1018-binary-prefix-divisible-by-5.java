class Solution {
   public List<Boolean> prefixesDivBy5(int[] A) {
        int k = 0;
        List<Boolean> ans = new ArrayList<>();
        for (int a : A) {
           // System.out.println(k << 1);
           
            k = (k << 1 | a) % 5; // left shift k by 1 bit and plus current element a is the binary number.
            // System.out.println((k << 1 | a)+"  "+(k << 1 ));
            ans.add(k == 0); 
        }
        return ans;
    }
}