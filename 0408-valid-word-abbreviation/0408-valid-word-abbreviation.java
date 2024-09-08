class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i =0;
        int j=0;
        while(i < word.length() && j<abbr.length()) {
            if(Character.isLetter(abbr.charAt(j))) {//check for character in abbr
                if(word.charAt(i)!=abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }else {
                //check for digit in word
                int number =0;
                while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    number= number *10 + (abbr.charAt(j++) - '0');
                    if(number == 0) return false;
                }
                i+=number;
            }
        }
        
        return i == word.length() && j == abbr.length();
        
    }
}