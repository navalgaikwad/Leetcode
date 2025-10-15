class Solution {
    public int[] sumZero(int n) {
        int[] array = new int[n];
        for (int i = 0; i <= n - 2; i = i + 2) {
            array[i] = i + 1;
            array[i + 1] = -(i + 1);
        }
        return array;
    }
}