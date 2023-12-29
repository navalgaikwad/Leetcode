class Solution {
    //O(m * n),
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m+n];
        for(int i =m -1; i>=0; i--) {//start from end
            for(int j =n-1; j>=0; j--) {//start from end
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j; int p2 = i + j + 1; // this are position
                int sum = mul + pos[p2];//muliply plus value at that position
                pos[p1] += sum / 10;//remainder
                pos[p2] = (sum) % 10;//carry
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

// [0,     0]
// i+j, i+j+1n 