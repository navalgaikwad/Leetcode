class Solution {
    public int countHillValley(int[] arr) {
        int ans = 0, prev = arr[0];

        for(int i=1; i < arr.length - 1; i++) {
            
            if((arr[i] > prev && arr[i] > arr[i+1]) || (arr[i] < prev && arr[i] < arr[i+1])) {
                ans++;
                prev = arr[i];
            }

            
        }

        return ans;
    }
}