class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int j =0;
        int[] result =  Arrays.copyOf(prices, prices.length);
        for(int i =0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                result[stack.peek()] = prices[stack.peek()] - prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}

//i//1 - price 8 j 1
//i//2 - price 4 j 2
//i//3 - price 6 j 3
//i//4 - price 2 j 4
//i//5 - price 3 j 5
    
//i//1 - price 8 j 1
//i//2 - price 4 j 2  j>i

//8,4,6 
//4,4,6
//4, 
//4, 4, 6
//1. motha ala ki kahi karu noko, ani same ala ki
//2.bakicha vwli minus kar
//[8,4,6,2,3]
//2
//4, 2, 4,2, 3
//[2]
//4,2, 4, 2 