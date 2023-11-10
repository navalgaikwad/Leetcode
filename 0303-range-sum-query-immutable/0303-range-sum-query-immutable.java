class NumArray {
    int len = 0;
    int[] nums;
    public NumArray(int[] nums) {
        len = nums.length;
       this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
         
         int sumFromStart = 0, sumFromEnd = 0;
        for (int i = left; i <= right && right< len; i++) {
            sumFromStart += nums[i];
        }
        return sumFromStart;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//-2, 0, 3, -5, 2, -1
//-2,-2, 1, -4, -2, -3