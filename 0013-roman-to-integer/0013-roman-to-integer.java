class Solution {
    public int romanToInt(String s) {
      Map<String, Integer> map = new HashMap<>();
      map.put("I", 1);
      map.put("V", 5);
      map.put("X", 10);
      map.put("L", 50);
      map.put("C", 100);
      map.put("D", 500);
      map.put("M", 1000);
      map.put("IV", 4);
      map.put("IX", 9);
      map.put("XL", 40);
      map.put("XC", 90);
      map.put("CD", 400);
      map.put("CM", 900);
      int sum =0;
      String prev;
        //MCMXCIV
     for(int i=0; i<s.length(); i++){
        String st1 = s.substring(i, i+1);
          String st2="";
         if(i<=s.length()-2){
              st2 =s.substring(i, i+2); 
         }
       
         if(map.containsKey(st1)&& map.containsKey(st2)){
             sum =sum + map.get(st2);
             i=i+1;
         }else{
              if(map.containsKey(st1)){
                sum =sum + map.get(st1); 
             }else
            if(map.containsKey(st2)){
            sum =sum + map.get(st2); 
         }
        }
        
     }
        return sum;
    }
}