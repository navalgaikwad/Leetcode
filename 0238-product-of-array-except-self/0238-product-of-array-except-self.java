class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        
        
        //[1, 2,6,24]
        //[ 6,6,3,1]
        
        //[1, 1,2, 6]
        //[1,2,3,4]
        //[ 24,12,4,1]
        prefix[0] = 1;
        for(int i = 1; i<len; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        print(prefix);
        suffix[len - 1] = 1;
        for(int i = len-2; i>=0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }
       // print(suffix);
        
         int[] result = new int[len];
        for(int i=0; i<len; i++) {
            result[i] = suffix[i] * prefix[i];
        }
        return result;
    }
    
    void print(int[] arr) {
        for(int ar : arr) {
            System.out.print(ar+" ");
        }
    }
}

/*

//[1,2,3,4]
//[1,2,6,12]
//[6,6,3,1]

[1,2,3,4]
[6,6,3,1]
[1,2,6,12]
[]
*/