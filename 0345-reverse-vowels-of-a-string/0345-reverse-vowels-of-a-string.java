public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] charArray = s.toCharArray();
        int i=0;
        int j = s.length() - 1;
        while( i < j ) {
            if(!set.contains(charArray[i])) {
                i++;
                //continue;
            }
             else if(!set.contains(charArray[j])) {
                j--;
               // continue;
            }
            else {
            
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;  // Move i forward
            j--;  // Move j backward
            }
        }
        return String.valueOf(charArray);
    }
}