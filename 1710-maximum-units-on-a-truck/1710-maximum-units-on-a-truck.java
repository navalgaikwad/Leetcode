class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->(b[1] - a[1]));
        //System.out.print(boxTypes[0][0]);
        int result = 0;
        int i =0;
        while(  truckSize > 0 &&i< boxTypes.length) {
            int numberOfBoxes = boxTypes[i][0];
            int units = Math.min(numberOfBoxes, truckSize);
            result += (units * boxTypes[i][1]);
            truckSize= truckSize - numberOfBoxes;
            i++;
        }
        return result;
    }
}
