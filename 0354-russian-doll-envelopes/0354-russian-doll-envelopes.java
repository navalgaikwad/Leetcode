class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<envelopes.length; i++) {
            int height = envelopes[i][1];
            if(set.isEmpty() || height > set.getLast()) {
                set.add(height);
            }else {
                int replace = set.ceiling(height);
                set.remove(replace);
                set.add(height);
            }
        }
        return set.size();
    }
}