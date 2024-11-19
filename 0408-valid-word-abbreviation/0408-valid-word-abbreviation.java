class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i =0;
        int j =0;
        while(i < word.length() && j < abbr.length()) {
            int number = 0;
            if(Character.isDigit(abbr.charAt(j))) {
                while(j < abbr.length() &&Character.isDigit(abbr.charAt(j))) {
                    number = number * 10 + (abbr.charAt(j) - '0');
                     if(number == 0) return false;
                    j++;
                }
                i+=number;
            }else {
                if(word.charAt(i)!=abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();    
      }
                      
                  
    }

                      