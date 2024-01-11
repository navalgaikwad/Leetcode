```
for (int i = 0; i < n; i++) {
if (money[i] > 1000)
add[i] = true;
for (int j = i + 1; j < n; j++) {
if (name[i].equals(name[j]) && Math.abs(time[i] - time[j]) <= 60 && !city[i].equals(city[j])) {
add[i] = true;
add[j] = true;
}
}
}
for (int i = 0; i < n; i++) {
if (add[i])
ans.add(transactions[i]);
}
return ans;
```