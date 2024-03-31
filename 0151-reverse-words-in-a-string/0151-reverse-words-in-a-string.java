class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=1; i--) {
            sb.append(arr[i].trim());
            sb.append(" ");
        }
        sb.append(arr[0].trim());
        return sb.toString();
    }
}