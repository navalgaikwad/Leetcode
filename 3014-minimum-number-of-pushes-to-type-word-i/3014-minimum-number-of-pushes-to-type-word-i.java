class Solution {
    public int minimumPushes(String word) {
        int push = 0;
        for(int value=0;value<word.length();value++){
           
            if(value/8 == 0) {
             push+=1;   
            }else if(value/8 == 1) {
                push+=2;
            }else if(value/8 == 2) {
                push+=3;
            }else {
                push+=4;
            }
        }
        return push;
    }
}