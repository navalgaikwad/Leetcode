class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<>());
        }
        for(String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }
        //System.out.print(map);
        int count = 0;
        for(char c : s.toCharArray()) {
            Deque<String> q = map.get(c);
            int size = q.size();
            for(int i = 0; i<size; i++) {
                String word = q.removeFirst();
                if(word.length() == 1) {
                    count++;
                }else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }
}

/*
The time complexity of this algorithm is O(S + W), where S is the length of the string S and W is the total number of characters in 
all words in the words array. The space complexity is O(W), where W is the total number of characters in all words in the words array, 
due to the storage of words in deques.
*/