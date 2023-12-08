​
public boolean startsWith(String prefix) {
return findLastNode(prefix) != null;
}
​
private Node findLastNode(String str) {
Node curr = root;
for (char ch : str.toCharArray()) {
if (!curr.children.containsKey(ch)) {
return null;
}
curr = curr.children.get(ch);
}
return curr;
}
​
// Usage
public static void main(String[] args) {
Trie trie = new Trie();
trie.insert("apple");
System.out.println(trie.search("apple"));   // returns true
System.out.println(trie.search("app"));     // returns false
System.out.println(trie.startsWith("app")); // returns true
trie.insert("app");
System.out.println(trie.search("app"));     // returns true
}
}
​
```