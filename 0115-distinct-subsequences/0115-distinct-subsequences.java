class Solution {
    public int numDistinct(String S, String T) {
        int sl = S.length();
	    int tl = T.length();
	
	int [] preComb = new int[sl+1];
	int [] comb = new int[sl+1];
	
	
	for(int i=0; i<=sl; i++)
		preComb[i] = 1;		

	for(int t=1; t<=tl; ++t){
		for(int s=1; s<=sl; ++s){
			if(T.charAt(t-1) != S.charAt(s-1)){
				comb[s] = comb[s-1];
			}else{
				comb[s] = comb[s-1] + preComb[s-1];
			}
		}
		
		for(int i=0; i<=sl; ++i){
			preComb[i] = comb[i];
		}
	}
	
	return comb[sl];
    }
}

