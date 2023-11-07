class Solution {
    public int halveArray(int[] nums) {
        //[5,19,8,1]
        //19 9.5
        //[9.5, 8, 5, 1]//1
        //[8, 4.5, 5, 1]//2
        //[5, 4, 4.5, 1]//3
        //total = 33 half = 14
        Double total =0.0;
    PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));

        for(int num : nums){
            pq.add((double)num);
            total = total+num;
        }
        Double half = total / 2;
        int count =0;
        while(!pq.isEmpty()&& total > half){ // [5,19,8,1] [19, 8, 5, 1]
            Double num = pq.remove();//19
            num = num / 2;//9.5
            total = total - num;//33 - 
            count++;
            pq.add(num);
            // if(total < half){
            //     return count;
            // }
         
        }
        return count;
    }
}