class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val =0;
        int i =0;
        for(String operation:operations) {
            if(operations[i].charAt(1) == '+') {
                val++;
            }else {
                val--;
            }
            i++;
        }
        return val;
    }
}

