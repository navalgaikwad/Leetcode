public boolean check(int k, int[] dist) {
double t = 0;
for (double d: dist) {
t = Math.ceil(t);
t += d / k;
}
return t <= limit;
}