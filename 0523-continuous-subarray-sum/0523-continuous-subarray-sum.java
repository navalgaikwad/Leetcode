class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n =nums.length;
        int i =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int prefixSum =0;
        while(i < n) {
            prefixSum = (prefixSum + nums[i])%k; //its length is at least two (prefixSum + nums[i]) and
            if(map.containsKey(prefixSum)) {
                if(i + 1 - map.get(prefixSum) >=2) { //checked len greater than 2 
                    return true;
                }
            }else {
                map.put(prefixSum, i + 1);
            }
            i++;
        }
        return false;
    }
}

/*
the sum of the elements of the subarray is a multiple of k.
(prefixSum + nums[i])%k
*/