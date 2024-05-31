class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0 , right=numbers.length-1;
        while((numbers[left]+numbers[right])!=target){
            if((numbers[left]+numbers[right])>target)
            right--;
            else if((numbers[left]+numbers[right])<target)
            left++;
        }
        int[] res = new int[2];
        res[0]=left+1;
        res[1]=right+1;
        return res;
    }
}