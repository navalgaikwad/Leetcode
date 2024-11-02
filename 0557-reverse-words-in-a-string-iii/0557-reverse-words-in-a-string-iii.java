class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int lastSpace = -1;
        int len = s.length();//no -1 vvimp
        for(int i =0; i<= s.length(); i++) {//vimp i<=s.lenght
            if(i == len || arr[i] == ' ') {
                int start = lastSpace + 1;
                int end = i - 1;
                while(start < end) {
                    char temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp; 
                    start++;
                    end--;
                }
                lastSpace = i;
            }
        }
        return new String(arr);
    }
}
