class TrieNode {
Map<Character, TrieNode> children;
List<String> suggestion;
TrieNode() {
this.children = new HashMap<>();
this.suggestion = new ArrayList<>();
}
}
​
class Solution {
public List<List<String>> suggestedProducts(String[] products, String searchWord) {
TrieNode root = new TrieNode();
for(String product: products) {
TrieNode node = root;
for(char c : product.toCharArray()) {
if(!node.children.containsKey(c)) {
node.children.put(c, new TrieNode());
}
node = node.children.get(c);
node.suggestion.add(product);
Collections.sort(node.suggestion);
if(node.suggestion.size() > 3) {
node.suggestion.remove(node.suggestion.size() - 1);
}
}
}
List<List<String>> ans = new ArrayList<>();
TrieNode node = root;
for(char c :  searchWord.toCharArray()) {
if(node.children.containsKey(c)) {
node = node.children.get(c);
ans.add(node.suggestion);
}else {
node.children = new HashMap<>();
ans.add(new ArrayList<String>());
}
}
return ans;
}
}