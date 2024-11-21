class Solution {
    
       boolean isValid(String num) {
        for(char c : num.toCharArray()) {
            if( c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    public String discountPrices(String sentence, int discount) {
        String[] arr = sentence.split("\\s+");
        for(int i=0; i<arr.length; i++) {
            String word = arr[i];
            char dollar = word.charAt(0);
            String num = word.substring(1);
            if( word.length() > 1 && dollar == '$' && isValid(num)) {
                arr[i] = String.format("$%.2f", Long.parseLong(num) * (1 - discount/100d));
            }
        }
        
        return String.join(" ", arr);
    }
}