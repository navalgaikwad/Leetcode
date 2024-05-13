if(s.charAt(i) == '|') {
count = i;
}
rightSide[i] = count;
}
count = -1;
for(int i = length-1; i >= 0; i--) {
if(s.charAt(i) == '|') {
count = i;
}
leftSide[i] = count;
}
int[] result = new int[queries.length];
int i =0;
for(int[] querie:queries) {
int left = leftSide[querie[0]];
int right = rightSide[querie[1]];
if(left !=-1 && right !=-1 && left < right) {
result[i++] = Math.abs(plate[right] - plate[left]);
}else {
result[i++] = 0;
}
}
return result;
}
}