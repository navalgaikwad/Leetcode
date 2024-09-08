class Solution {
// O(n + m) time | O(1) space
public boolean validWordAbbreviation(String word, String abbr) {
int i = 0;
int j = 0;
while(i < word.length() && j < abbr.length()) {
if(Character.isLetter(abbr.charAt(j))) {
if(word.charAt(i) != abbr.charAt(j)) return false;
i++;
j++;
} else {
int number = 0;
while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
number *=10;
number += abbr.charAt(j++) - '0';
if(number == 0) return false;
}
i += number;
}
}
return i == word.length() && j == abbr.length();
}
}