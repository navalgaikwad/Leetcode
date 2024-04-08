class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i=0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int j =0;
        for(int i =0; i < count.length; i++) {
            int value = count[i];
            while(value > 0) {
                nums[j++] = i;
                value--;
            }
        }
    }
}