class Solution {
     //private String phoneDigits;
    List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", 
        '3', "def", 
        '4', "ghi", 
        '5', "jkl", 
        '6', "mno", 
        '7', "pqrs", 
        '8', "tuv", 
        '9', "wxyz");
    public List<String> letterCombinations(String digits) {
         if (digits.length() == 0) {
            return combinations;
        }
        
        // Initiate backtracking with an empty path and starting index of 0
        //phoneDigits = digits;
        backtrack(0, new StringBuilder(), digits);
        return combinations;
    }
    // Intitution
    //length path length is equal to digit length
    
    private void backtrack(int index, StringBuilder path, String digits) {
        if(path.length() == digits.length()){ //
            combinations.add(path.toString()); //ad ae af
            return;
        }
         String possibleLetters = letters.get(digits.charAt(index)); // abc // def
         for(char letter : possibleLetters.toCharArray()){
            path.append(letter); //ad
            backtrack( index + 1, path, digits); //1, a,  23 // digits.charAt(1);
            path.deleteCharAt(path.length() - 1);
         }
    }
    
}