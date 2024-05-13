class Solution {
public int maximumUnits(int[][] boxTypes, int truckSize) {
Arrays.sort(boxTypes, (a, b)->b[1] - a[1]);
int i =0;
int sum =0;
while(truckSize > 0 && i < boxTypes.length) {
int noBoxes = boxTypes[i][0];
int boxToPick=Math.min(noBoxes, truckSize);
sum = sum + (boxToPick * boxTypes[i][1]);
truckSize = truckSize -noBoxes;
i++;
}
return sum;
}
}