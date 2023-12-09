class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if(mid%2 == 1) {
                mid--;
            }
            if(nums[mid]!=nums[mid+1]) {
                right = mid-1;
            }else {
                left = mid + 2;
            }
            
        }
        return nums[left];
    }
}
//check on odd and even position
//if i get mid which is even check next elemnt is is not equal
// if not equal value is at left side
//if not then left side increamnet left side by 2 becuae there are 2 element