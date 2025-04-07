class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // Min Heap (stores larger half of elements)
        TreeSet<Integer> minset = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : Integer.compare(nums[a], nums[b]));
        // Max Heap (stores smaller half of elements)
        TreeSet<Integer> maxset = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : Integer.compare(nums[b], nums[a]));

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // Add new element
            if (maxset.size() <= minset.size()) {
                minset.add(i);
                maxset.add(minset.pollFirst());
            } else {
                maxset.add(i);
                minset.add(maxset.pollFirst());
            }

            // When the window reaches size k, compute median
            if (i >= k - 1) {
                if (k % 2 == 0) {
                    result[i - k + 1] = ((double) nums[minset.first()] + nums[maxset.first()]) / 2.0;
                } else {
                    result[i - k + 1] = (double) nums[maxset.first()];
                }

                // Remove outdated element
                int outdatedIndex = i - k + 1;
                if (!minset.remove(outdatedIndex)) {
                    maxset.remove(outdatedIndex);
                }
            }
        }
        return result;
    }
}
