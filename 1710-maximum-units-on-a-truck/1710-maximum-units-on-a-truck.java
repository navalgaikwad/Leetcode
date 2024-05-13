class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->(b[1] - a[1]));
        //System.out.print(boxTypes[0][0]);
        int result = 0;
        int i =0;
        while(  truckSize > 0 &&i< boxTypes.length) {
            int noOfUnitPerBox = boxTypes[i][0];
            int boxToPickSize = Math.min(noOfUnitPerBox, truckSize);
            result = result + (boxToPickSize * boxTypes[i][1]);
            truckSize= truckSize - noOfUnitPerBox;
            i++;
        }
        return result;
    }
}
