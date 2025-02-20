class Solution {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        Arrays.sort(ages);
        for(int i=0; i<ages.length; i++) {
            int low = helper(ages, (ages[i]/2) + 7);
            int upper = helper(ages, ages[i]);

            res+=Math.max(upper-low-1, 0);
        }
        return res;
    }

    int helper(int[] ages, int target) {
        int s = 0;
        int e = ages.length-1;
        while(s <= e) {
            int mid = s + (e - s)/2;
            if(ages[mid] <= target) {
                s = mid + 1;
            }else {
                e = mid - 1;
            }
        }
        return s;

    }
}