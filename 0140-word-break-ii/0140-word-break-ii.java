class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
      ArrayList<ArrayList<String>> results =  dp(s, wordDict, new HashMap<>());
        
        if (results == null){
            return new ArrayList<String>();
        }
        
        List<String> answer = new ArrayList<>();
        
        for(ArrayList<String> result : results){
                String joinedString = String.join(" ", result);
                answer.add(joinedString);                

        }
        return answer;
    }
    
    
    ArrayList<ArrayList<String>> dp(String target, List<String> wordDict, HashMap<String, ArrayList<ArrayList<String>>> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        
        if(target.isEmpty()){
            ArrayList<ArrayList<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        
        ArrayList<ArrayList<String>> allCombinations = null;
        
        for(String word :wordDict){
            
            if(target.startsWith(word)){
                
                ArrayList<ArrayList<String>> combinations = dp(target.substring(word.length()), wordDict, memo);
                
                if(combinations != null){
                    
                    if (allCombinations == null){
                        allCombinations = new ArrayList<>();
                    }
                    
                    ArrayList<ArrayList<String>> newCombinations = new ArrayList<>();
                    for(ArrayList<String> combination: combinations){
                        ArrayList<String> newCombination = new ArrayList<String>(combination);
                        newCombination.add(0, word);
                        newCombinations.add(newCombination);
                    }
                    
                    allCombinations.addAll(newCombinations);
                }
            }
        }
        
        
        memo.put(target, allCombinations);
        return allCombinations;
    }
}