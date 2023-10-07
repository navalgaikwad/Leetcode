class Solution {
    public int maxRepeating(String s, String word) {
        //check word with sequences
        //if present increase the count
        StringBuilder sb=new StringBuilder(word);
        int count=0;
        while( s.contains(sb)){
            count++;
            sb.append(word);
        }
        return count;
    }
}