int index = 0;
for(int i=len-1; i>=0; i--) {
if(s.charAt(i)==('|')) {
index = i;
}
leftCandels[i] = index;
}
index = 0;
for(int i=0; i<len; i++) {
if(s.charAt(i)==('|')) {
index = i;
}
rightCandels[i] = index;
}
int[] result = new int[queries.length];
int k=0;
for(int[] query:queries) {
int value1 = query[0];
int value2 = query[1];
int leftIndex = leftCandels[value1];
int rightIndex = rightCandels[value2];
if(leftIndex!=0 && rightIndex!=0) {
result[k++] = plates[rightIndex] - plates[leftIndex];
}
}