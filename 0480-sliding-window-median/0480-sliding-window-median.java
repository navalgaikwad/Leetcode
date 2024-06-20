class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> minSet = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : Integer.compare(nums[a], nums[b]));
        TreeSet<Integer> maxSet = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : Integer.compare(nums[a], nums[b]));
        double[] medians = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (minSet.size() <= maxSet.size()) {
                maxSet.add(i);
                minSet.add(maxSet.pollFirst());
            } else {
                minSet.add(i);
                maxSet.add(minSet.pollLast());
            }
            if (i - k + 1 >= 0) {
                if (k % 2 == 0) {
                    medians[i - k + 1] = ((double) nums[minSet.last()] + nums[maxSet.first()]) / 2;
                } else {
                    medians[i - k + 1] = (double) nums[minSet.last()];
                }
                if (!minSet.remove(i - k + 1)) {
                    maxSet.remove(i - k + 1);
                }
            }
        }
        return medians;
    }
}