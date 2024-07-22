class Solution {
    class Pair {
        String name;
        int height;
        Pair(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.height - a.height);
        
        for(int i=0; i<names.length; i++) {
            pq.add(new Pair(names[i], heights[i]));
        }
        String[] result = new String[names.length];
        int i=0;
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            result[i++] = p.name;
        }
        return result;
    }
}