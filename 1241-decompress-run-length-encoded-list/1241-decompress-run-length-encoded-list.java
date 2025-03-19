class Solution {
    public int[] decompressRLElist(int[] nums) {
        int len = nums.length;
        int arrSize = 0;
        for (int i = 0; i < len; i += 2)
            arrSize += nums[i];

        int[] res = new int[arrSize];

        int ind = 0;
        for (int i = 0; i < len; i += 2)
            for (int j = 0; j < nums[i]; j++)
                res[ind++] = nums[i + 1];

        return res;
    }
}