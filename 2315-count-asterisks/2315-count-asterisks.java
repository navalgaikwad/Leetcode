class Solution {
    public int countAsterisks(String s) {
        int j=0; int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='*')
                count++;
				
            if(s.charAt(i)=='|')
            {
				j=i+1;
			   while(s.charAt(j)!='|') { j++;}
				i=j;
            }        
        }
        return count;
    }
}