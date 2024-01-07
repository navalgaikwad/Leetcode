class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int count =0;
        for(int i = n-1; i>=0 && citations[i]>count; i-- ) {
            count++;
        }
        return count;
    }
}
// [3,0,6,1,5]
//[      5,5,5]
