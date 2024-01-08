class Solution {
    public int halveArray(int[] nums) {
        if(nums.length<2){
            return 1;
        }
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b)->Double.compare(b,a));
        double sum = 0;
        for(int num : nums) {
            sum = sum + num;
            pq.add((double)num);
        }
        double half = sum/2;
        double count =0;
        while(sum > half) {
            double value = pq.remove();
            value = value/2;
            sum = sum - value;
            pq.add(value);
            count++;
        }
        return (int)count;
    }
}