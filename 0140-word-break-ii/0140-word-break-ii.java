class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
       List<List<String>> dp[] = new ArrayList[ s.length() + 1];
       List<List<String>> baseList = new ArrayList<>();
       baseList.add(new ArrayList<String>());
       dp[0] = baseList;
       int targetLength = s.length();
        
       for(int i = 0; i <= targetLength; i++){
           
          if(dp[i] != null){
             for(String word :wordDict){
            
                 if( i + word.length()<= targetLength && s.substring(i ,i+ word.length()).equals(word)){
                 List<List<String>> previousCombinations = dp[i];
             
                 List<List<String>> newCombinations = new ArrayList<>();
                     
                    for(List<String> combination: previousCombinations){
                      ArrayList<String> newCombination = new ArrayList<>();
                      newCombination.addAll(combination);
                      newCombination.add(word);
                      newCombinations.add(newCombination);
                    }
                     if(dp[i +  word.length()]==null){
                         dp[i +  word.length()] = newCombinations;   
                     }else{
                         dp[i +  word.length()].addAll(newCombinations);
                     }
                  
                 }
             } 
          } 
       }
        List<String> currentResult = new ArrayList<>();
      if(dp[targetLength]==null){
          return currentResult;
      }
         
        for(List<String> newCombination: dp[targetLength]){
      
           currentResult.add(String.join(" ", newCombination));
     
        }
      return currentResult;
    }
}

 //[["cats", "and", "dog"],["cat", "sand", "dog"]]