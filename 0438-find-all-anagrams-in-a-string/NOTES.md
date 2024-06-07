class Solution {
public List<Integer> findAnagrams(String s, String p) {
Map<Character, Integer> map = new HashMap<>();
for(char c : p.toCharArray()) {
map.put(c, map.getOrDefault(c, 0) + 1);
}
int size = map.size();
int left =0;
int min = Integer.MAX_VALUE;
List<Integer> result = new ArrayList<>();
for(int right =0; right <s.length(); right++) {
char cright = s.charAt(right);
if(map.containsKey(cright)) {
map.put(cright, map.getOrDefault(cright, 0) - 1);
if(map.get(cright)==0) {
size--;
}
}
while(size == 0) {
if(right - left + 1 == p.length()) {
result.add(left);
//min = right - left + 1;
}
char cleft = s.charAt(left);
if(map.containsKey(cleft)) {
map.put(cleft, map.getOrDefault(cleft, 0) + 1);
if(map.get(cleft)>0) {
size++;
}
}
left++;
}
}
return result;
}
}