class Solution {
   public static int minimumDeletions(String s) {

        if (s == null || s.isEmpty()) return 0;

        int countB = 0; //keep a count of Bs
        int removals = 0; //keep a count of removed As

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'a') {
                if (countB > 0) { // only if there are Bs before this A
                    removals++; // remove this A
                    countB--; // and decrement the Bs count
                }
            } else {
                countB++; // keep incrementing the Bs count
            }
        }
       return removals;
}
}
