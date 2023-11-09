class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new int[]{profits[i], capital[i]}); //addd profit and capital
        }
        projects.sort((a, b) -> Integer.compare(a[1], b[1]));// sorted based on capital
        
        PriorityQueue<Integer> maxProfitQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));// sorted in maxium
       // System.out.print(maxProfitQueue);
        int total = w;
        int index = 0;
        while (k > 0) {
            while (index < n && projects.get(index)[1] <= total) { //if they have same add to queue
                 //System.out.println(projects.get(index)[0]);
                maxProfitQueue.add(projects.get(index)[0]);
                index++;
            }
            if (maxProfitQueue.isEmpty()) {
                break;
            }
            total += maxProfitQueue.poll();
            k--;
        }

        return total;
    }
}
