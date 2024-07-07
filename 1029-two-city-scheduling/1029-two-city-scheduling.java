class Solution {
    public int twoCitySchedCost(int[][] cost) {
        Arrays.sort(cost, (a,b)->{
           return ( a[0] - a[1]) - (b[0] - b[1]);
        });
        int price =0;
        for(int i=0; i<cost.length/2;i++) {
            price+=cost[i][0];
        }
        for(int i=cost.length/2; i<cost.length;i++) {
            price+=cost[i][1];
        }
        return price;
    }
}
