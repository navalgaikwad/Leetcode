class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] copyOfPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(copyOfPeople);
        Arrays.sort(flowers, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> endTimePq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int peopleTime : copyOfPeople) {
            while( i < flowers.length && flowers[i][0] <= peopleTime) {
                endTimePq.add(flowers[i][1]);
                i++;
            }
            while(!endTimePq.isEmpty() && endTimePq.peek() < peopleTime) {
                endTimePq.remove();
            }
            map.put(peopleTime, endTimePq.size());
        }
        for(int j=0; j<people.length; j++) {
            copyOfPeople[j] =map.get( people[j]); 
        }
        return copyOfPeople;
    }
}