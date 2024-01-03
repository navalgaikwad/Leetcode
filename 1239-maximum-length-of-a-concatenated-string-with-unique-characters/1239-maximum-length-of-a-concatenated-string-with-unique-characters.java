class Solution {
   int max=0;
    public int maxLength(List<String> arr) {
        dfs( arr,0,  "");
        return max;
    }
    
   void dfs(List<String> arr, int curr, String current){
       if(max < current.length()){
           max = current.length();
       }
       for(int i = curr; i< arr.size(); i++){
           if(!isValid(current,  arr.get(i))){ //
               continue;
           }
           dfs(arr, i+1, current+arr.get(i));
       }
   }

    boolean isValid(String current, String newString){
        int[] count = new int[26];
        for(int i=0;i<newString.length(); i++){
           ++count[newString.charAt(i) - 'a']; 
            if(count[newString.charAt(i) - 'a'] == 2){ //duplicate
                return false;
            }
            if(current.contains(newString.charAt(i)+"")){//check for duplicate entry
                return false;
            }
        }
       return true;
    }
}

//  int max =0;
//     public int maxLength(List<String> arr) {
//         backTrack(arr,"",0);
//         return max;
//     }
    
//     private void backTrack(List<String> arr, String current, int start){
//         if(max<current.length())
//             max =current.length();
//         for(int i=start; i<arr.size();i++){
//             if(!isValid(current,arr.get(i))) continue;
//             backTrack(arr,current+arr.get(i),i+1);
//         }
//     }
    
//     private boolean isValid(String currentString, String newString){
//         int[] array = new int[26];
//         for(int i=0;i<newString.length();i++){
//             if(++array[newString.charAt(i)-'a'] == 2) return false;  //to handle if the newString has duplicates then it's not valid
//             if(currentString.contains(newString.charAt(i)+"")) // check if the currentString contains each char from newString
//                 return false;
//         }
//         return true;
//     }

// class Solution {
//    int max=0;
//     public int maxLength(List<String> arr) {
//         dfs( arr,0,  "");
//         return max;
//     }
    
//    void dfs(List<String> arr, int curr, String current){
//        if(max < current.length()){
//            max = current.length();
//        }
//        for(int i = curr; i< arr.size(); i++){
//            if(!isValid(current,  arr.get(i))){ //
//                continue;
//            }
//            dfs(arr, i+1, current+arr.get(i));
//        }
//    }

//     boolean isValid(String current, String newString){
//         int[] count = new int[26];
//         for(int i=0;i<newString.length(); i++){
//            ++count[newString.charAt(i) - 'a']; 
//             if(count[newString.charAt(i) - 'a'] == 2){ //duplicate
//                 return false;
//             }
//             if(current.contains(newString.charAt(i)+"")){//check for duplicate entry
//                 return false;
//             }
//         }
//        return true;
//     }
// }

//  int max =0;
//     public int maxLength(List<String> arr) {
//         backTrack(arr,"",0);
//         return max;
//     }
    
//     private void backTrack(List<String> arr, String current, int start){
//         if(max<current.length())
//             max =current.length();
//         for(int i=start; i<arr.size();i++){
//             if(!isValid(current,arr.get(i))) continue;
//             backTrack(arr,current+arr.get(i),i+1);
//         }
//     }
    
//     private boolean isValid(String currentString, String newString){
//         int[] array = new int[26];
//         for(int i=0;i<newString.length();i++){
//             if(++array[newString.charAt(i)-'a'] == 2) return false;  //to handle if the newString has duplicates then it's not valid
//             if(currentString.contains(newString.charAt(i)+"")) // check if the currentString contains each char from newString
//                 return false;
//         }
//         return true;
//     }


