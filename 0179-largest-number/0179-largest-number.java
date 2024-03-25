
class Solution {
   private class Largest implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String one = a + b;
            String two = b + a;
            return two.compareTo(one);
        }
    }
    public String largestNumber(int[] nums) {
        
       // StringBuilder sb = new StringBuilder();
        
        String[] array = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, new Largest());
         if(array[0].equals("0") ) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i =0 ;i <array.length; i++) {
            sb.append(array[i]);
        }
        
       // System.out.print(array);
        return sb.toString();
    }
}