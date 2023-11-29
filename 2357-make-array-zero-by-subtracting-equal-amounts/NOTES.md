​
```
//Find the distinct value in MaxHeap or normal heap and return size of it.
public int minimumOperations(int[] nums) {
PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
for(int num : nums){
if(num!=0 && !pq.contains(num)){
pq.add(num);
}
}
return pq.size();
}
```
​
​
​
```
//Add the value in the set without zero
Set<Integer> set = new HashSet<>();
for(int num : nums){
if(num!=0) {
set.add(num);
}
}
```
​
​
​