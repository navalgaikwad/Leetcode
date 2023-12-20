class Solution {
    public String robotWithString(String s) {
        int[] frequency = new int[26];
        for(int i =0; i<s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        StringBuilder result= new StringBuilder();
        for(int i =0;i<s.length(); i++) {
            stack.push(s.charAt(i));
            frequency[s.charAt(i) - 'a']--;
            
            while(!stack.isEmpty() && helper(stack.peek(), frequency)) {
                result.append(stack.pop());
            }
        }
        return result.toString();
    }
    
    boolean helper(char s, int[] frequency) {
        for( int i = 'a'; i<s; i++) {
            if(frequency[ i - 'a']>0) {
                return false;
            }
        }
        return true;
    }
    
}