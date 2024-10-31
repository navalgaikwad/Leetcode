class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int size = Integer.MAX_VALUE;
        String smallest ="";
        for(int i = 0; i<strs.length; i++) {
            if(strs[i].length() < size) {
                size = strs[i].length();
                smallest = strs[i];
            }
        }//o(n)
        int j ;
        //System.out.print(smallest);
        for(int i =0; i<smallest.length(); i++) {//(k)
            for( j =0; j<strs.length; j++) {//n
                if(smallest.charAt(i) != strs[j].charAt(i)) {
                   
                    return sb.toString();
                }
            }
            sb.append(smallest.charAt(i));
        }
       return sb.isEmpty()? "" : sb.toString();
        //return "";
    }
}