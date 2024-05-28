class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] arr = paragraph.toLowerCase().replaceAll("\\W+", " ").split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for(String a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(String ban : banned) {
            map.remove(ban);
        }
        int max = -1;
        String ans = "";
        for(String para : map.keySet()) {
            if(map.get(para) > max) {
                max = map.get(para);
                ans = para;
            }
           
        }
        
        return ans;
    }
}