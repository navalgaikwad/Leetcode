import java.util.Stack;
​
class Solution {
public String decodeString(String s) {
Stack<Integer> numberStack = new Stack<>();
Stack<String> alphaStack = new Stack<>();
String val = ""; // This holds the current decoded string
int len = s.length();
for (int i = 0; i < len; i++) {
char c = s.charAt(i);
// If it's a digit, compute the number (for cases like "10[abc]")
if (Character.isDigit(c)) {
int number = 0;
// Handle multi-digit numbers
while (i < len && Character.isDigit(s.charAt(i))) {
number = number * 10 + (s.charAt(i) - '0');
i++;
}
numberStack.push(number);
i--; // Adjust the index since we overstep it in the inner while loop
}
// If we encounter an opening bracket, push the current `val` onto the stack and reset `val`
else if (c == '[') {
alphaStack.push(val); // Store the current accumulated value
val = ""; // Reset for the next portion inside the brackets
}
// If we encounter a closing bracket, pop the top of the stacks and repeat the string
else if (c == ']') {
StringBuilder sb = new StringBuilder(alphaStack.pop()); // Retrieve the last stored string
int num = numberStack.pop(); // Retrieve the number of times to repeat
for (int j = 0; j < num; j++) {
sb.append(val); // Repeat the current `val`
}
val = sb.toString(); // Update `val` to the newly built string
}
// If it's a letter, accumulate it into `val`
else {
val += c;
}
}
return val; // Return the fully decoded string
}
}
​