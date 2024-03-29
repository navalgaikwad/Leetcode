class Solution {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int len = s.length();
        int last = -1;
        for(int i = 0; i<=len; i++) {
            if( i== len || array[i] ==' ') {
                int start = last + 1;
                int end = i - 1;
                while(start < end) {
                    char temp = array[start];
                    array[start] = array[end];
                    array[end] = temp;
                    start++;
                    end--;
                }
                last = i;
            }
        }
        return new String(array);
    }
}