class Solution {
//     public int maxRepeating(String s, String word) {
//        int count=0;
//        int m = word.length();
//         int j=0;
//         int max=0;
//       for(int i=0; i<=s.length()-m; i++){
//           if(j==m){
//               j=0;
//           }
//           if(s.charAt(i)==word.charAt(j)){
//               count++;
//               j++;
//           }else{
//               count=0;
//               j=0;
//           } 
//           if(count == m*(count/2)){
//               max=Math.max(max, count/2);
//           }
          
//       }
//         return max;
        
//     }
     public int maxRepeating(String sequence, String word) {
        int repeating = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            repeating++;
            sb.append(word);
        }
        return repeating;
    }
}