class Solution {
    public boolean halvesAreAlike(String s) {
       Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int mid = s.length()/2;
        int counter = 0;
        for(int i=0; i<mid; i++) {
            if(set.contains(s.charAt(i))) {
                counter++;
            }
            if(set.contains(s.charAt(i+mid))) {
                counter--;
            }
            //mid = mid + 1;
        }
        return counter == 0;
    }
}