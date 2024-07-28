class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            for(int j = i;j<s.length();j++){
                if(s.charAt(i) != s.charAt(j)) break;
                String temp = s.substring(i, j+1);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
       int max=-1;
        for(Map.Entry<String,Integer> x:map.entrySet()){
            if(x.getValue()>=3)
            {
                max=Math.max(max,x.getKey().length());
            }
        }
        return max;
    }
}