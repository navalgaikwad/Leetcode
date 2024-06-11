class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp =  row[i] == 0 ? 1 : 0;;
                row[i] = row[C - 1 - i] == 0 ? 1 : 0;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
}