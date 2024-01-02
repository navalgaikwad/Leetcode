class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length) {
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<>();
        for(int i =0 ;i<pattern.length(); i++) {
            char c = pattern.charAt(i);//a
            String str = arr[i];//dog
            if(map.containsKey(c)) {
                String value = map.get(c);
                if(!value.equals(str)) {
                    return false;
                }
            }else {
                if(map.containsValue(str)) {
                    return false;
                }
                map.put(c, str);
            }
        }
        return true;
    }
}


//pattern = "abba", s = "dog cat cat dog"
//"abba"   "dog dog dog dog"

