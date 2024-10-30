class Solution {
    public String reformatDate(String date) {
        HashMap<String,String>map=new HashMap<>();
        map.put("Jan","01");
        map.put("Feb","02");
        map.put("Mar","03");
        map.put("Apr","04");
        map.put("May","05");
        map.put("Jun","06");
        map.put("Jul","07");
        map.put("Aug","08");
        map.put("Sep","09");
        map.put("Oct","10");
        map.put("Nov","11");
        map.put("Dec","12");
      
        StringBuilder sb = new StringBuilder();
        String[] array = date.split("\\s+");
        
        sb.append(array[2]);
        sb.append("-");
        sb.append(map.get(array[1]));
        sb.append("-");
        
        char a = array[0].charAt(0);
        String b = a+"";
        char c = array[0].charAt(1);
        
        if(Character.isDigit(c)) {
            b+=c;
        }else {
            b ='0' + b;
        }
        sb.append(b);
        System.out.print(array[0]);
        return sb.toString();

    }
}