class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        prices[src] = 0;

        for(int i = 0; i <= k; i++){
            
            int[] temp = new int[n];
            temp = Arrays.copyOf(prices, prices.length);

            for(int[] fl : flights){
                int s = fl[0], d = fl[1], p = fl[2];

                if(prices[s] == Integer.MAX_VALUE) continue;

                int pricesFromHere = prices[s] + p;

                if(pricesFromHere < temp[d]) temp[d] = pricesFromHere;
            }

            prices = temp;
        }

        System.gc();
        return (prices[dst] != Integer.MAX_VALUE) ? prices[dst] :  -1;
    }
}