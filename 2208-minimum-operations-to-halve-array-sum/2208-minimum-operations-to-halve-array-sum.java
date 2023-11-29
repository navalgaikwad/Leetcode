class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        if(nums.length<2){
            return 1;
        }
        double sum = 0;
        for(int num : nums){
            pq.add((double)num);
            sum = sum + num;
        }
        double half = (sum/2);
        int count =0 ;
        while(sum>half){
            double value = pq.remove();
            value = value/2;
            sum = sum - value;
            pq.add(value);
            count++;
        }
        return count;
    }
}

//5,19,8,1
//25+8 = 33 /2 = 16.5

//19.5 9.5
//16.5
//19,8,5,1 = 33 - 9.5 = 23.5 > 16.5
//9.5, 8, 5, 1
//8,5, 4.75,1 23.5 - 4.74 = 18.75 > 16.5
//4