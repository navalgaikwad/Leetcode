class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs){
            char[] st = str.toCharArray();
            Arrays.sort(st);
            String strValue = String.valueOf(st);
            if(!map.containsKey(strValue)){
                ArrayList<String> value = new ArrayList<>();
                value.add(str);
                map.put(strValue, value);
            }else{
               ArrayList<String> value = map.get(strValue);
               value.add(str);
               map.put(strValue, value);
            }
        }
        //System.out.print(map);
         
        return new ArrayList(map.values());
    }
}