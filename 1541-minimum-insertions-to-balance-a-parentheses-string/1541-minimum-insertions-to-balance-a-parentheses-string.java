class Solution {
    public int minInsertions(String s) {
        
        int ans=0;       
        int cnt=0;
        for(char ch:s.toCharArray()) {     
            if(ch == '(') { //opeing
                cnt += 2;  //add 2
                if(cnt%2 != 0){ //if not even add increment ans
                    ans++;
                    cnt--;//
                }
            } else {       
                cnt -= 1;//closing
                if(cnt < 0){//less than 0
                    ans++;
                    cnt+=2;//add 2 
                } 
            }           
        }
        return ans + cnt;
    }
}
//  ))())(
//  cnt = -1 < 0, 1,0, 2,1,0,2,1
//  ans= 2
//  cnt + ans
//  
//when open (
//cnt+2// for closing
    //cnt is odd
        //incremnt ans++
        //cnt--
//cnt is less than 0
    //increment ans++
    //cnt+2

//return ans+cnt