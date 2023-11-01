class Solution {
     public void rotate(int[] nums, int k) {
         k=k% nums.length;
        reverse(nums, 0, nums.length-1); //reverse it
        reverse(nums, 0, k-1);//then reverse till k -1
        reverse(nums, k, nums.length-1); // then reverse it after k to lenght
        
        
    }

    void reverse(int[] array, int start, int end){
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
       
    }
}

