class Solution {
    public boolean isWithinTwoDistance(String query, String word) {
        int diff = 0;
        int n = query.length();
        if(word.length() != n) return false;

        for(int i=0; i<n; i++) {
            if(word.charAt(i) != query.charAt(i)) diff++;
        }

        return diff <=2;

    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        Set<String> sol = new HashSet<>();
        for(String query : queries) {
            for(String word : dictionary) {
                if(isWithinTwoDistance(query, word)) {
                    sol.add(query);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (String q : queries) {
        if (sol.contains(q)) {
            result.add(q);
        }
    }
        return result;
    }
}