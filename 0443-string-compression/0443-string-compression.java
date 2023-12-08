class Solution {
    public int compress(char[] chars) {
        //take one char search untill you find reapeating character
        //find the count
        //if count >1 then append to char
        //otherwise 
        int i = 0;
        int index =0;
        while(i < chars.length) {
            char ch = chars[i];
            int count =0;
            while(i < chars.length && ch == chars[i]) {
                i++;
                count++;
            }
            chars[index++] = ch;
            if(count > 1) {
                 for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}