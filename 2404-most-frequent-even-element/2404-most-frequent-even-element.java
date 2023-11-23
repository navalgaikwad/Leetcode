class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] arr = new int[100001];
        int result = 1;
        for(int num : nums){
            if(num % 2 == 0){
                arr[num]++;
                if ( (arr[result] < arr[num]) || (arr[result] == arr[num] && result > num) ){
                    result = num;
                }
            }
        }
        return result == 1 ? -1 : result;

    }
}
