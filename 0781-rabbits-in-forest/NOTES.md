class Solution {
public int numRabbits(int[] answers) {
Map<Integer, Integer> counts = new HashMap<>();
int count = 0;
​
for (int answer : answers) {
if (answer == 0) {
// This must be the only rabbit of its color.
count++;
} else if (counts.getOrDefault(answer, 0) == 0) {
// This is the first time the color appears.
counts.put(answer, 1);
// Add all rabbits having this color.
count += answer + 1;
} else {
// Add one to how many times answer occurred.
counts.put(answer, counts.get(answer) + 1);
if (counts.get(answer) > answer) {
// n+1 rabbits have said n, so color done.
counts.put(answer, 0);
}
}
}
return count;
}
}