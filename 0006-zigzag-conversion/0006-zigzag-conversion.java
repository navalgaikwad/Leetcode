class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        ArrayList<Character> adj[] = new ArrayList[numRows];
        for(int i=0; i<numRows; i++) {
            adj[i] = new ArrayList<>();
        }
        int j =0;
        for(int i = 0; i<n; i++) {
            for(int k=0; k < numRows && j < n; k++) {
                adj[k].add(s.charAt(j++));
            }
            for(int k=numRows-2; k >= 1 && j < n; k--) {
                adj[k].add(s.charAt(j++));
            }
        }
         StringBuilder sb = new StringBuilder();
        for(ArrayList<Character> li : adj) {
            for(Character val: li) {
                sb.append(val);
            }
        }
        return sb.toString();
    }
}