class Solution {
    class Largest implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String one = a + b;
            String two = b + a;
            return two.compareTo(one);
        }
    }
    public String largestNumber(int[] nums) {
        
        String[] result = new String[nums.length];
        int i =0;
        for(int num : nums) {
            result[i++]=String.valueOf(num);
        }
         
        Arrays.sort(result, new Largest());
        if(result[0].equals("0") ) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        
        for(String res : result) {
            sb.append(res);
        }
        return sb.toString();
    }
}