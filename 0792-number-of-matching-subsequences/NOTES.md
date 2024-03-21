class Solution {
//O(m * k * n)
public int numMatchingSubseq(String s, String[] words) {
int count=0;
for(String word: words){
if(subSequnces(s, word)){
count++;
}
}
return count;
}
boolean subSequnces(String s, String word){
int index=0;
for(char wrd: word.toCharArray()){
int indx = s.indexOf(wrd, index);
if(indx==-1){
return false;
}
index=indx+ 1;
}
return true;
}
}