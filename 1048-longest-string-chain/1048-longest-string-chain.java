class Solution {
    public int longestStrChain(String[] words) {
        int max =1;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a,b)->a.length() -b.length());
        for(String word : words) {
            int longest = 1;
            for(int i=0; i<word.length(); i++) {
                String temp = word.substring(0, i) + word.substring(i+1); //break it first a then b for ba 
                if(map.containsKey(temp)) {
                    int len = map.get(temp) + 1;
                    longest =Math.max(longest, len);
                }
            }
            max = Math.max(max, longest);
            map.put(word, longest);
        }
        return max;
    }
}
//  public int longestStrChain(String[] words) {
//         int max = 1;
//         Arrays.sort(words, (a,b)->a.length() -b.length());
//         Map<String, Integer> map = new HashMap<>();
//         for(String word: words){
//              int longestChain = 1;
//             for(int i=0;i<word.length(); i++){
//                 String temp = word.substring(0, i) + word.substring(i+1);
//                 if(map.containsKey(temp)){
//                     int length = map.getOrDefault(temp, 1) + 1;
                   
//                     longestChain =Math.max(longestChain, length);
//                 }
               
//             }
//              map.put(word, longestChain);
//              max = Math.max(max, longestChain);
//         }
//         return max;
//     }