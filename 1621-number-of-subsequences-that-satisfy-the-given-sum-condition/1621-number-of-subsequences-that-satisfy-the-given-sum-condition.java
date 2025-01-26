class Solution {
  public int numSubseq(int[] nums, int target) {
    var n = nums.length;
    Arrays.sort(nums);

    var exp = new int[n];
    exp[0] = 1;

    for (var i=1; i<n; i++)
      exp[i] = (exp[i-1] * 2) % 1000000007;

    int i = 0, j = n-1, cnt = 0;

    while (i <= j) {
      if (nums[i] + nums[j] <= target) {
        cnt = (cnt + exp[j-i]) % 1000000007;
        i++;
      } else {
        j--;
      }
    }
    return cnt;
  }
}