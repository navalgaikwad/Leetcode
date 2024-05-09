class Solution {
    public String rankTeams(String[] votes) {
      Map<Character, int[]> map = new HashMap<>();
        
      int col = votes[0].length();
        
      for(String vote : votes){
        for(int i = 0; i < col; i++){
          char c = vote.charAt(i);
          map.putIfAbsent(c, new int[col]);
          map.get(c)[i]++;
        }
      }
      
      List<Character> list = new ArrayList<>(map.keySet());
      Collections.sort(list, (a,b) -> {
        for(int i = 0; i < col; i++){
          if(map.get(a)[i] != map.get(b)[i]){
            return map.get(b)[i] - map.get(a)[i];
          }
        }
        return 0;
      });
      
      StringBuilder sb = new StringBuilder();
      for(char c : list){
        sb.append(c);
      }
      return sb.toString();
    }
}