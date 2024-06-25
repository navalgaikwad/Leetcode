class Solution {
    public int maxFrequencyElements(int[] nums) {
        //Map<Integer, Integer> map = new HashMap<>();
        int[] map = new int[101];
        int totalCount =0;
        int max = 0;
        for(int num : nums) {
            map[num]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num : map) {
            pq.add(num);
        }
        while(!pq.isEmpty()) {
            int num = pq.remove();
            
            if(num > max) {
                totalCount = num;
                max = num;
            }else if(max == num) {
                totalCount+=num;
            }
        }
        return totalCount;
    }
}