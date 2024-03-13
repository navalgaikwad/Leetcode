class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] arr = s.split(" ");
        
        if(pattern.length() != arr.length) return false;
        
        Map<Character, String> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        int len = pattern.length();
        
        for(int i = 0; i< len; i++) {
            char ch = pattern.charAt(i); //a
            String value = arr[i];//dog
            
            if(!map.containsKey(ch)) {
                if(visited.contains(value)) {
                    return false;
                }
                visited.add(value);//dog, cat
                map.put(ch, value);//a - dog, b- cat
            } else {
                String existingValue = map.get(ch);// dog
                if(!existingValue.equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}


//bijection
//"abba", s = "dog cat cat dog"

//pattern = "abba", s = "dog cat cat fish"
/**
pattern = "aaaa", s = "dog cat cat dog"

//both lower case

1. both should be same
2. take a map particular elemnt is prent or not
3. if it is not presnet i w
4. if it match

Set

a - dog
b - dog

 
"aaaa", s = "dog cat cat dog"



// a - dog, cat
// b

//add both in seta
// setb
//a - dog
// a - dog
// b - cat
//
a - dog
b


**/