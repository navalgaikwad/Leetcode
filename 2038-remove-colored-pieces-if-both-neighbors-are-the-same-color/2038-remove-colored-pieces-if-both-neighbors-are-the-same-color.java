class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        if(n<=2) return false;
        int A  = 0;
        int B = 0;
        
        for(int i =1; i<n-1; i++) {
            char c = colors.charAt(i);
            char prev = colors.charAt(i-1);
            char next = colors.charAt(i+1);
            if(prev==c && c=='A' && next==c) A++;
            if(prev==c && c=='B' && next==c) B++;
            
        }
        if(A > B) return true;
        return false;
    }
}