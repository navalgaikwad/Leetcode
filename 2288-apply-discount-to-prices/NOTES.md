class Solution {
private boolean isValidNum(String num) {
for (int i = 0; i < num.length(); ++i) {
char c = num.charAt(i);
if (c < '0' || c > '9') {
return false;
}
}
return true;
}
public String discountPrices(String sentence, int discount) {
String[] words = sentence.split(" ");
for (int i = 0; i < words.length; ++i) {
String word  = words[i];
String num = word.substring(1);
if (word.length() > 1 && word.charAt(0) == '$' && isValidNum(num)) {
words[i] = String.format("$%.2f", Long.parseLong(num) * (1 - discount / 100d));
}
}
return String.join(" ", words);
}
}
//seperate by  " "
/*
check for 1 charcter is $ ani num valid ahe ka
ahe tar String.formate("$%.2f", formula);
String.join(" ", words);
*/