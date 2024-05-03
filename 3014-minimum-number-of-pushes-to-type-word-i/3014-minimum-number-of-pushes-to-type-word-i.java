class Solution {
    public int minimumPushes(String word) {
     int push =0;
     for(int i=0;i<word.length();i++){
         if(i/8==0){
             push++;
         }
         else if(i/8==1){
             push+=2;
         }
         else if(i/8==2){
             push+=3;
         }
         else{
             push+=4;
         }
     }  
     return push; 
    }
}
/*

Intuition
we have to map the 26 letters of the english alphabet into the 8 buttons of the phone.

Approach
As all the letters in the word will be distinct. so we can iterate over the length of the word by using the for loop. let map the first 8 letters of the word on the first 8 buttons, now map other 8 letters of the word on the button on pushing these letter it will cost 2 each for every push. similary perform for other tasks.
*/