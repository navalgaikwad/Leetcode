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
if( i + word.length() <= targetLength && s.substring(i , i + word.length()).equals(word)){
List<List<String>> previousCombinations = dp[i];
List<List<String>> newCombinations = new ArrayList<>();
//combine the previous comibination and current combination
for(List<String> combination: previousCombinations){
ArrayList<String> newCombination = new ArrayList<>();
newCombination.addAll(combination);
newCombination.add(word);
newCombinations.add(newCombination);
}