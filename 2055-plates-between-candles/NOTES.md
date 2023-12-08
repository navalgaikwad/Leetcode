index = i;
}
rightCandels[i] = index;
}
//then find the left index and right index and leftIndex < rightIndex
int[] result = new int[queries.length];
int k = 0;
for(int[] query:queries) {
int value1 = query[0];
int value2 = query[1];
int leftIndex = leftCandels[value1];
int rightIndex = rightCandels[value2];
if(leftIndex != -1 && rightIndex != -1 && leftIndex < rightIndex) {
result[k++] = Math.abs(plates[rightIndex] - plates[leftIndex]);
}else {
result[k++] = 0;
}
}
return result;
// return new int[]{};
}
}
```