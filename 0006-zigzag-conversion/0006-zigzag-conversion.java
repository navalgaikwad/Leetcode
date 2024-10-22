class Solution {
    public String convert(String s, int numRows) {
          if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        int len = s.length();
        ArrayList<Character> arr[] = new ArrayList[len];
        for(int i=0; i<len; i++) {
            arr[i] = new ArrayList<>();
        }
        int j =0;
        while(j < len) {
            for(int i =0; i<numRows&& j < len; i++) {
                arr[i].add(s.charAt(j++));
            }
            for(int i = numRows-2; i>=1&& j < len; i--) {//numrow -2 && i>=1
                arr[i].add(s.charAt(j++));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < arr.length; k++) {
            for (char c : arr[k]) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}