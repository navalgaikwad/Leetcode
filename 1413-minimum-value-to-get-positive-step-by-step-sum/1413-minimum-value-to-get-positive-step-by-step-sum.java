class Solution {
    public int minStartValue(int[] nums) {
        int currentPrefixSum = 0;
        int minPrefixSum = 0; 
        for (int num : nums) {
            currentPrefixSum += num;
            minPrefixSum = Math.min(currentPrefixSum, minPrefixSum);
          
        }
        System.out.print(minPrefixSum);
        return -(minPrefixSum) +1;
    
    }
}