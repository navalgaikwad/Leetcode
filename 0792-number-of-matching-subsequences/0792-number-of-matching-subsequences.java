class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for(char i='a'; i<='z'; i++) {
            map.putIfAbsent(i, new LinkedList<>());
        }
        for(String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }
        int count = 0;
        for(char c : s.toCharArray()) {
            Deque<String> q = map.get(c);
            int size = q.size();
            for(int k = 0; k < size; k++) {
                String value = q.removeFirst();
                if(value.length() == 1) {
                    count++;
                }else {
                    map.get(value.charAt(1)).addLast(value.substring(1));
                }  
            }
        }
        return count;
    }
}
