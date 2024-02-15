class Solution {
    public int minInsertions(String s) {
        int cnt =0;
        int ans =0;
        for(Character c : s.toCharArray()) {
            if(c == '(') {
                cnt+=2;
                if(cnt%2!=0) {
                    cnt--;
                    ans++;
                }
            }else {
                cnt--;
                if(cnt< 0) {
                    cnt+=2;
                    ans++;
                }
            }
        }
        return ans+cnt;
    }
}

//(()))
//cnt=1
//

//())
//cnt=2
//

//))())(
//
//cnt+=2 1, 0,2, 1,0, 2,1
//ans=1,2