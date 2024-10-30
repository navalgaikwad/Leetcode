class Solution {
    public String convert(String s, int numRows) {
        ArrayList<Character>list[] = new ArrayList[numRows];
        for(int i=0; i<numRows; i++) {
            list[i] = new ArrayList<>();
        }
        int j =0;
        for(int i =0; i<s.length(); i++) {
            for(int k =0; k<numRows && j < s.length(); k++) {
                list[k].add(s.charAt(j++));
            }
            for(int k =numRows-2; k>=1 && j < s.length(); k--) {
                list[k].add(s.charAt(j++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(ArrayList<Character> li : list) {
            for(Character val: li) {
                sb.append(val);
            }
        }
        return sb.toString();
    }
}