class Solution {
    class TrieNode {
       
        Map<Character, TrieNode> children = new HashMap<>();
        ArrayList<String> suggesation = new ArrayList<>();
        TrieNode() {
           children = new HashMap<>();
           suggesation = new ArrayList<>();
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        
        for(String product :products) {
            TrieNode node = root;
            for(char c: product.toCharArray()) {
                if(!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
                node.suggesation.add(product);
                Collections.sort(node.suggesation);
                if(node.suggesation.size() > 3) {
                    node.suggesation.remove(node.suggesation.size()-1);
                }
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        TrieNode node = root;
        for(char c : searchWord.toCharArray()) {
            if(node.children.containsKey(c)) {
                node = node.children.get(c);
                ans.add(node.suggesation);
            }else {
                node.children = new HashMap<>();
                ans.add(new ArrayList<>());
            }
        }
        return ans;
    }
}