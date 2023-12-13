class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);
        Arrays.sort(flowers, (a, b) -> Arrays.compare(a, b));
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> endTimeheap = new PriorityQueue();
        int i = 0;
        
        for(int person : sortedPeople) {
            while(i < flowers.length && flowers[i][0] <= person) {//start date is less than person date
                endTimeheap.add(flowers[i][1]);//add in the queue
                i++;
            }
            while(!endTimeheap.isEmpty() && endTimeheap.peek() < person) {//
                endTimeheap.remove();
            }
            map.put(person, endTimeheap.size());
        }
        
        int[] ans = new int[people.length];
        for (int j = 0; j < people.length; j++) {
            ans[j] = map.get(people[j]);
        }
        
        return ans;
    }
}