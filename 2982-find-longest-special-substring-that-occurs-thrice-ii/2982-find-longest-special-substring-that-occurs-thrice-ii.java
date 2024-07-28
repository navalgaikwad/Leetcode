class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> countMap = new HashMap();
        int n = s.length();
        int i = 0;

        while(i<n){
            int j = i;
            while(j<n && s.charAt(j) == s.charAt(i))
                j++;
            
            String subs = s.substring(i, j);

            if(subs.length() >= 3){
                String subs1 = s.substring(i, j-1);
                String subs2 = s.substring(i, j-2);

                countMap.put(subs, countMap.getOrDefault(subs, 0) + 1);
                countMap.put(subs1, countMap.getOrDefault(subs1, 0) + 2);
                countMap.put(subs2, countMap.getOrDefault(subs2, 0) + 3);
            }
            else if(subs.length() >= 2){
                String subs1 = s.substring(i, j-1);

                countMap.put(subs, countMap.getOrDefault(subs, 0) + 1);
                countMap.put(subs1, countMap.getOrDefault(subs1, 0) + 2);
            }
            else{
                countMap.put(subs, countMap.getOrDefault(subs, 0) + 1);
            }
            i = j;
        }        

        int ans = -1;
        for(Map.Entry<String, Integer> entry: countMap.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();

            if(val >= 3)
                ans = Math.max(ans, key.length());
        }

        return ans;
    }
}