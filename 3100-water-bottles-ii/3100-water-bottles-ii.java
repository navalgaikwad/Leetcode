class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = numBottles;
        int emptyWaterBottle = numBottles;
        while(emptyWaterBottle >= numExchange) {
            emptyWaterBottle-=numExchange;
            numExchange++;
            result++;
            emptyWaterBottle++;
        }
        return result;
    }
}