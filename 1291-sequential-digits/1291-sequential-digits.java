class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digit = "123456789";
        int nlow = String.valueOf(low).length();
        int nhigh = String.valueOf(high).length();
        List<Integer> result = new ArrayList<>();
        for(int i = nlow; i<= nhigh; i++) {
            for(int j = 0; j< 10-i; j++) {
                int num = Integer.parseInt(digit.substring(j , j + i));
                if( num>=low && num <=high) {
                    result.add(num);
                }
            }
        }
        return result;
    }
}