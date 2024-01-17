class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int p = 0, start = 0, end = n-1;
        p = partition(nums, start, end);
        while(start < end && (n-p) != k){
            if((n-p) < k){
                end = p-1;
            } else {
                start = p+1;
            }
            p = partition(nums, start, end);
        }
        return nums[p];
    }

    public int partition(int[] nums, int start, int end){
        int i = start, j = end;
        int pivot = nums[start];

        while(i < j){
            while(i < end && nums[i] <= pivot) i++;
            while(j > start && nums[j] > pivot) j--;
            if(i < j) swap(nums, i ,j);
        }
        if(nums[j] < pivot) swap(nums, start, j);
        return j;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}