class Solution {
    public int minOperations(int n) {
        //even ani odd
        int a = n/2;
        if(n%2 == 0) {
            return a * a;
        }else {
           
            return a*(a + 1);
        }
    }
}