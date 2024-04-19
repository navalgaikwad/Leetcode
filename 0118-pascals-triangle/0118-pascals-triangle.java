class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            rows.add(0, 1);
            for(int j =1; j<rows.size()-1; j++) {
                rows.set(j, rows.get(j) + rows.get(j+1));
            }
            allrows.add(new ArrayList<>(rows));
        }
        return allrows;
    }
}