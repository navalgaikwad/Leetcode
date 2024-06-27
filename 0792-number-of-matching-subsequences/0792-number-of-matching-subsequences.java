class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for(char i = 'a'; i <='z'; i++) {
            map.put(i, new LinkedList<>());
        }
        for(String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }
        int count = 0;
        for(char c : s.toCharArray()) {
            Deque<String> current = map.get(c);
            int size = current.size();
            for(int i =0; i<size; i++) {
                String value = current.removeFirst();
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