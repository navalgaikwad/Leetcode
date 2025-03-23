class Solution {
    public int numFriendRequests(int[] ages) {
        int result = 0;
        Arrays.sort(ages);
        for (int i = 0; i < ages.length; i++) {
            int lower = helper(ages, 0, ages.length - 1, (ages[i] / 2) + 7);
            int higher = helper(ages, 0, ages.length - 1, (ages[i]));
            result += Math.max(higher - lower - 1, 0);
        }
        return result;
    }

    int helper(int[] ages, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ages[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
//sort karycha
/