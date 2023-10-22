unique ncbedhcbehyujjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjyy`class Solution {
public int uniquePaths(int m, int n) {
return recurssion(m, n, new HashMap<>());
}
int recurssion(int m, int n, HashMap<String, Integer> map){
String key = m+"-"+n;
if(map.containsKey(key)){
return map.get(key);
}
if(m == 1 && n == 1){
return 1;
}
if(m == 0 || n == 0){
return 0;
}
int val1 =  recurssion(m - 1, n, map);
int val2 =  recurssion(m, n - 1, map);
map.put( key, val1 + val2);
return map.get(key);
}
}`