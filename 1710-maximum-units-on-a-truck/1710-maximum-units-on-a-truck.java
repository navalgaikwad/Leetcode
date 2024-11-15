class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->(b[1] - a[1]));
        int i = 0;
        int result = 0;
        while( i < boxTypes.length && truckSize > 0) {
            int box = boxTypes[i][0];
            int boxToPick = Math.min(truckSize, box);
            result += (boxToPick * boxTypes[i][1]);
            truckSize = truckSize - box;
            i++;
        }
        return result;
    }
}