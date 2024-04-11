class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int l = 0, r = 0, i = 0, n = chars.length;
        while (i < n) {
            while (i < n && chars[i] != ' ')
                chars[r++] = chars[i++];

            if (l < r) {
                reverse(chars, l, r - 1);
                if (r == n) break;
                chars[r++] = ' ';
                l = r;
            }
            ++i;
        }
        if (r > 0 && chars[r - 1] == ' ') --r;
        return new String(chars, 0, r);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
