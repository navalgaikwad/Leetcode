class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = 0;
        int i =0;
        for(int house :houses) {
            while( i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= 2*house) {
               i++;
            }
             max = Math.max(max, Math.abs(heaters[i] - house));
        }
        return max;
    }
}
