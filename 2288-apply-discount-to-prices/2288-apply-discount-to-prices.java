class Solution {
     //character number
    boolean isValid(String word) {
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c < '0' || c >'9') {
                return false;
                
            }
        }
        return true;
    }
    public String discountPrices(String sentence, int discount) {
        String[] arr = sentence.split(" ");
        for(int i=0; i<arr.length; i++ ){
            String word = arr[i];
            String num = word.substring(1);//next word check karyla
            if(word.length() > 1 &&  word.charAt(0)=='$' && isValid(num)) {
                arr[i] = String.format("$%.2f", Long.parseLong(num) * (1 - discount/100d));
            }
        }
    
        return String.join(" ", arr);
            
    }
}