i++;
}
}
return res;
}
}
public static String decodeString1(String s) {
Stack<String> st = new Stack<>();
Stack<Integer> number = new Stack<>();
String buildString = "";
StringBuilder result = new StringBuilder();
for (int i = 0; i < s.length(); i++) {
char value = s.charAt(i);
if (Character.isDigit(value)) {
int count = 0;
while (Character.isDigit(s.charAt(i))) {
count = count * 10 + Character.getNumericValue(s.charAt(i));
i++;
}
number.push(count);
i--; // Decrement i to account for the increment in the loop
} else if (value == '[') {
st.push(buildString);
buildString = "";
} else if (value == ']') {
StringBuilder sb = new StringBuilder(st.pop());
int no = number.pop();
while (no-- > 0) {
sb.append(buildString);
}
buildString = sb.toString();
} else {
buildString += s.charAt(i);
}
}
result.append(buildString);
return result.toString();
}
​