class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        //remove extra closing
        char[] arr = s.toCharArray();
        int count =0;
        for(int i=0; i<arr.length; i++) {
            if(s.charAt(i) == '(') {
                count++;
            }else if(s.charAt(i) == ')'){
                if(count == 0) {
                    arr[i] = '#';
                }else {
                    count--;
                }
            }
        }
        count = 0;
        for(int i=arr.length-1; i>=0; i--) {
            if(s.charAt(i) == '(') {
                 if(count == 0) {
                    arr[i] = '#';
                }else {
                    count--;
                }
            }else if(s.charAt(i) == ')'){
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            if(c!='#') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}