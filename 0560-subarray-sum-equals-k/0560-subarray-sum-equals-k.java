import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int curr = 0;
        int ans = 0;

        for (int num : nums) {
            curr += num;

            // Check if (curr - k) exists in the map
            if (map.containsKey(curr - k)) {
                ans += map.get(curr - k);
            }

            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        return ans;
    }
}
