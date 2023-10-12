class Solution {
    
    public int[] platesBetweenCandles(String st, int[][] queries) {
      int len = queries.length;
      int[] left = new int[st.length()];
      int[] right = new int[st.length()];
      int[] sum = new int[st.length()];
      int[] result = new int[len];
        
        int counter = -1;
        for(int i= 0; i<st.length(); i++){
            if(st.charAt(i)=='|'){
                counter = i;
            }
            left[i]=counter;     
        }
        counter=-1;
        for(int i= st.length()-1; i>= 0; i--){
            if(st.charAt(i)=='|'){
                counter = i;
            }
            right[i] = counter;   
        }
        
        counter= 0;
        for(int i= 0; i<st.length(); i++){
            if(st.charAt(i)=='*'){
                counter += 1;
            }
            sum[i] = counter;   
        }
        
        int i=0;
        for(int[] q: queries){
            int l = q[0];
            int r = q[1];
            l = right[l];
            r = left[r];
            if(l ==-1 || r == -1 || r<l){
                result[i++]=0;
            }else{
                 result[i++]=sum[r]- sum[l];
            }  
        }
       return result; 
    }
}