class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25] - 1;
        int idleSlot = maxFreq * n;

        for(int i=24; i>=0 && freq[i] > 0; i--) {
            idleSlot-=Math.min(maxFreq, freq[i]);
        }
        return idleSlot > 0 ? tasks.length + idleSlot : tasks.length;
    }
}