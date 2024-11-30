class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length - 1;
        int n = nums2.length - 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        Set<String> visited = new HashSet<>();
        visited.add(0+"-"+0);
        List<List<Integer>> result = new ArrayList<>();
        while(k-- >0 &&!pq.isEmpty()) {
            int[] top = pq.remove();
           
            int i = top[1];
            int j = top[2];
             result.add(List.of(nums1[i], nums2[j]));
            while(i + 1 < nums1.length && !visited.contains((i + 1)+"-"+ j)) {
                pq.add(new int[]{nums1[i+1] + nums2[j], i + 1, j});
                 visited.add((i + 1)+"-"+j);
            }
            while(j + 1 < nums2.length && !visited.contains((i)+"-"+ (j+1))) {
                pq.add(new int[]{nums1[i] + nums2[j+1], i, j+1});
                visited.add((i)+"-"+(j+1));
            }
        }
        return result;
    }
}