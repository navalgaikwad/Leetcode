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
            curr += num; //prefix sum kar

            // Check if (curr - k) exists in the map(1,2,3,4) k =2 (3 -1) = 2 : (4 -2) = 2
            if (map.containsKey(curr - k)) { //value asel tarr add kar ans
                ans += map.get(curr - k);
            }

            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        return ans;
    }
}
