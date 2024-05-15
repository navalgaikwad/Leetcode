class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        int col = votes[0].length();
        for(String vote : votes) {
            for(int i=0; i<col; i++) {
                map.putIfAbsent(vote.charAt(i), new int[col]);
                map.get(vote.charAt(i))[i]++;
            }
        }
        System.out.print(map);
        List<Character> listOfVotes = new ArrayList<>(map.keySet());
        Collections.sort(listOfVotes, (a, b) -> {
            for(int i=0; i<col; i++) {
                if(map.get(a)[i]!=map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for(char c:  listOfVotes) {
            sb.append(c);
        }
        return sb.toString();
    }
}

//O(n * m * log(m)).
//O(m^2).