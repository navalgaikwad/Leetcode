class Solution {
    public boolean digitCount(String num) {
        char temp[] = new char[11];
        int temp1 = 0 , temp2 = 0;
        for(int i=0; i<num.length(); i++){
            char ch = num.charAt(i); temp1 = ch-'0';
            temp[temp1]++;
        }
        for(int i=0; i<num.length(); i++){
            char ch = num.charAt(i); temp2 = ch-'0';
            if(temp[i]!=temp2) return false;
        }
        return true;
    }
}