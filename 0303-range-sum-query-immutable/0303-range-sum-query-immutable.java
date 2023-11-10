class NumArray {
    int len = 0;
    int[] preSum;
    public NumArray(int[] nums) {
        len = nums.length;
       this.preSum = nums;
        int sumFromStart = 0, sumFromEnd = 0;
        for (int i = 1; i < len ; i++) {
            preSum[i] =preSum[i] +nums[i - 1];
           // System.out.print( preSum[i]+" "+ i +" ");
        }
    }
    
    public int sumRange(int left, int right) {
         if (left == 0) return preSum[right];
        
         return preSum[right] - preSum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//-2, 0, 3, -5, 2, -1
//-2,-2, 1, -4, -2, -3

// class NumArray { // 6 ms, faster than 100.00%
//     int[] preSum;
//     public NumArray(int[] nums) {
//         preSum = nums; // pass by pointer!
//         for (int i = 1; i < preSum.length; ++i)
//             preSum[i] += preSum[i-1]; 
//     }
    
//     public int sumRange(int left, int right) {
//         if (left == 0) return preSum[right];
//         return preSum[right] - preSum[left-1];
//     }
// }