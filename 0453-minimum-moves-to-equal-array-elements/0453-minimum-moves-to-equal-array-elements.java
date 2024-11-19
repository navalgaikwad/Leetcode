// Intuitive

// To make elements equal, it means we need to make the difference between min element and max element in array equal to 0.
// In each move, we can increase all n-1 elements by one. We should never choose to increase our max element, so we choose to increase other elements except our current max element, it means we decrease the difference between the max element and the min element by one.
// So in each move, we need to decrease the current max element by one to util every elements become min element.
// The problem become: count difference between other elements with our min element in the array.
// For example: nums = [1, 2, 3]
// Step 1, increase other elements except a maximum element 3, nums = [2, 3, 3]
// Step 2, increase other elements except a maxium element, nums = [3, 4, 3].
// Step 3, increase other elements except a maximum element, nums = [4, 4, 4].
// Complexity

// Time: O(N), where N <= 10^5 is the length of nums array.
// Space: O(1)
// Java

class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int x : nums) min = Math.min(min, x);
        int ans = 0;
        for (int x : nums) 
            ans += x - min;
        return ans;
    }
}
//find min
//then minus from everyone