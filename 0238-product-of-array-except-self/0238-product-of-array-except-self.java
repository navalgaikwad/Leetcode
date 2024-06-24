class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        prefix[0] = 1;
        for(int i=1; i < len; i++) {
            prefix[i] = prefix[i - 1] * nums[i -1];
        }
        
        int suffix = 1;
        for(int i=len-1; i >= 0; i--) {
            prefix[i] = prefix[i] * suffix;
            suffix*=nums[i];
        }
        return prefix;
    }
    
}

/*

//[1,2,3,4]
1, 1,2, 6
//[1,2,6,12]
//[6,6,3,1]

[1,2,3,4]
[6,6,3,1]
[1,2,6,12]
[]
*/