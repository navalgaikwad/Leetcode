class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum %2 != 0) return false; //odd sum will not yield two partition

        //target sum in each partition
        int target = sum/2;

        //initialize with zero
        Set<Integer> set = new HashSet<>();
        set.add(0);

        for(int n : nums) {
            Set<Integer> sumsToCurrentNum = new HashSet<>();

            for(int s : set) {

                if(s + n == target) return true;
                if(s + n < target) sumsToCurrentNum.add(s+n);
            }

            //collect the current sums to parent set
            set.addAll(sumsToCurrentNum);
        }

        return false;
    }
}
    //find total sum
    // if not even return false
    //define dp of sum+1 of boolean type
    //for from i to nums.lenght
    //for from sum to nums[i] j--

    // static boolean tabulation(int target, int[] num) {
    //     boolean[] table = new boolean[target + 1];
    //     table[0] = true;
    //     for (int i = 0; i < target; i++) {  // Fix: Change i <= target to i < target
    //         if (table[i]) {
    //             for (int nu : num) {
    //                 if (i + nu <= target) {
    //                     table[i + nu] = true;
    //                 }
    //             }
    //         }
    //     }
    //     return table[target];
    // }
