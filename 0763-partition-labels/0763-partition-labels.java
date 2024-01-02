class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0 ;i<s.length(); i++) {
            map.put(s.charAt(i), Math.max(i, map.getOrDefault(s.charAt(i), 0)));
        }// to find last index of character
        
        int left = 0;
        int max = -1;
        for(int right = 0; right<s.length(); right++) {
            
            max = Math.max(max, map.get(s.charAt(right)));
            if(right == max) {
                result.add(right - left + 1);
                left = right+1;
                max = -1;
            }
        }
        return result;
    }
}