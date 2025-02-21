class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length(); int n = num2.length();
        int[] arr = new int[Math.max(m, n) + 1];
        int i =0, j =0;
        m = m-1;
        n = n-1;
        int k = arr.length - 1;
        while(m>=0 || n>=0) {
            int digit1 = (m>=0) ? (num1.charAt(m) -'0') : 0;
            int digit2 = (n>=0) ? (num2.charAt(n) -'0') : 0;

            int sum = digit1 + digit2 + arr[k];
            arr[k] = sum%10;
            arr[k-1] += sum/10;
            m--;
            n--;
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for(int a : arr) {
            if(!(sb.length()==0 && a == 0) ) {
                sb.append(a);
            }
        }
        return sb.toString().length() == 0 ? "0" : sb.toString();
    }
}