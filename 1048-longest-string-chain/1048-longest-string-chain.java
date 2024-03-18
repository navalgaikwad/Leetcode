class Solution {
    public int longestStrChain(String[] words) {
        int max = 1;
        Arrays.sort(words, (a,b)->a.length() -b.length());
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words) {
            int longest = 1;
            for(int i = 0; i < word.length(); i++) {
                
                String temp = word.substring(0, i) + word.substring(i + 1);
                if(map.containsKey(temp)) {
                    int len = map.get(temp) + 1;
                    longest = Math.max(longest, len);
                }
            }
            map.put(word, longest);
            max = Math.max(longest, max);
        }
        return max;
    }
}
//sort kar based on length
//map for saving the count of word
//run loop on words
//devide kart raha word 0 to i ani i + 1
//chek kar map madhey ahe ka, asel atr lonest range updadte kar in max ani map madhye
//return max
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