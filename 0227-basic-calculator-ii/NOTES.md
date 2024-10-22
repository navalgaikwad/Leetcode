class Solution {
public int calculate(String s) {
Stack<Integer> no = new Stack<>();
char sign = '+';//magic
int number = 0;
for(int i=0; i<s.length(); i++) {
if(Character.isDigit(s.charAt(i))) {
if(Character.isDigit(s.charAt(i))) {
number = number *10 + (s.charAt(i) - '0');
}
//i--;
} if(!Character.isDigit(s.charAt(i)) && !Character.isWhitespace(s.charAt(i)) || i == s.length()-1) {//i == len-1
if(sign == '+') {
no.push(number);//3
}else if(sign == '-') {
no.push(-number);
}else if(sign == '*') {
no.push(no.pop() * number);
}else if(sign == '/') {
no.push(no.pop()/number);