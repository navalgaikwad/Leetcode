class Solution {
    int minAbsoluteDifference(List<Integer> nums, int x) {
    int ans = Integer.MAX_VALUE;
    TreeSet<Integer> s = new TreeSet<>();
    for(int i = x; i < nums.size(); ++i){
        s.add(nums.get(i-x));
        Integer high = s.ceiling(nums.get(i)), low = s.floor(nums.get(i));
        if(high != null) ans = Math.min(ans, Math.abs(nums.get(i) - high));
        if(low != null) ans = Math.min(ans, Math.abs(nums.get(i) - low));
    }
    return ans;
}
}//O(n-x)logx