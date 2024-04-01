class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Find the intersection point of the two pointers
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the "entrance" to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
/*
Once the intersection point is found, the algorithm resets the slow pointer to the starting position (nums[0]) and keeps the fast pointer at the intersection point. Then, both pointers move at the same pace (one step at a time) until they meet again. The meeting point will be the "entrance" to the cycle, which corresponds to the index of the duplicate number in the array.

*/