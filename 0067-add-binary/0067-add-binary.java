class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length() -1;
        int lenB = b.length() - 1;
        int i = lenA;
        int j =lenB;
      //  int sum =0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || carry >0){
            int val1 = (i>=0) ?Character.getNumericValue(a.charAt(i)) : 0;//1
            int val2 =  (j>=0)?Character.getNumericValue(b.charAt(j)): 0;//1
            int sum = val1 + val2 + carry;//2
            carry = sum/2;//carry 1
            sum = sum%2;
            sb.insert(0, sum); 
            i--;
            j--;
        }
        return sb.toString();
    }
}