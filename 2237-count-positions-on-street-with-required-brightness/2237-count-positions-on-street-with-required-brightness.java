class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] status = new int[n + 1];
        for(int[] l : lights){
            status[Math.max(0, l[0] - l[1])]++;
            status[Math.min(n, l[0] + l[1] + 1)]--;
        }
        int brightness = 0, rst = 0;
        for(int i = 0; i < n; i++){
            brightness += status[i];
            if(brightness >= requirement[i])
                rst++;
        }
        return rst;
    }
}