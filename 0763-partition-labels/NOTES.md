class Solution {
public List<Integer> partitionLabels(String s) {
List<Integer> result = new ArrayList<>();
HashMap<Character, Integer> map = new HashMap<>();
for(int i = 0; i<s.length(); i++) {
map.put(s.charAt(i), Math.max(i, map.getOrDefault(s.charAt(i), 0)));
}
int left = 0;
int maxi = -1;
for(int right = 0; right<s.length(); right++) {
maxi = Math.max(maxi, map.get(s.charAt(right)));
if(maxi == right) {
result.add(right - left + 1);
left = right + 1;
maxi = -1;
}
}
return result;
}
}
​
//find the last elemnt of the character
//find max from map take it in max
// check for max == right
// thn update left = right +1
//then update length