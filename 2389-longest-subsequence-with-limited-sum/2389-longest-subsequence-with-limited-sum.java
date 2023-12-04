class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i =1; i<nums.length; i++){
            prefix[i] = nums[i] + prefix[i - 1];
        }
        
        int[] result = new int[queries.length];
        int i =0;
        for(int querie:queries) {
            result[i++] =findCount(prefix, querie);
        }
        return result;
    }
    
    int findCount(int[] prefix, int q) {
        int count =0;
        for(int i =0; i<prefix.length; i++){
            if(prefix[i]>q) {
                break;
            }
            count++;
        }
        return count;
    }
}
// nums = [4,5,2,1],
//1,2,4,5 1.sort
//3 . //do prefix sum
    // and find the no