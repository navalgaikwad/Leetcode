// Traverse right column
for (int i = top; i <= bottom; i++) {
result.add(matrix[i][right]);
}
right--;
​
// Ensure we are still within bounds after decrementing right or bottom
if (top <= bottom) {
// Traverse bottom row
for (int i = right; i >= left; i--) {
result.add(matrix[bottom][i]);
}
bottom--;
}
​
if (left <= right) {
// Traverse left column
for (int i = bottom; i >= top; i--) {
result.add(matrix[i][left]);
}
left++;
}
}
return result;
}
}
​
```