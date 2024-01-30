class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //determine total which is -1 start from zero
        //then by find start point
        int total =0;
        for(int i = 0; i < gas.length; i++) {
            total+=gas[i] - cost[i];
        }
        if(total < 0){
            return -1;
        }
        int start =0;
        int tank = 0;
        for(int i = 0; i < gas.length; i++) {
            tank+=gas[i] - cost[i];
            if(tank < 0){
                start = i+1;
                tank =0;
            }
        }
        return start;
    }
}