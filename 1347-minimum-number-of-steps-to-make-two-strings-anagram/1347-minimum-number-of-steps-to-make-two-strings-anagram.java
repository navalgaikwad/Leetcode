class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int replace = 0;
        for(char c : t.toCharArray()) { //when count ==0 it is the magic a ==0
            if(map.getOrDefault(c, 0) == 0){
                replace++;
            }else{
                map.put(c, map.getOrDefault(c, 0) - 1);
            }
        }
        return replace;
    }
}

//b = 1
//a = 0 count = 1
//











//b : 2
//a: 1

// int[] ch = new int[26];
//         for(char c : s.toCharArray()){
//             ch[c-'a']++;
//         }
//         int replace = 0;
//         for(char c : t.toCharArray()){
//             if(ch[c-'a']==0)
//                 replace++;
//             else
//                 ch[c-'a']--;
//         }
//         return replace;
    