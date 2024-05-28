import java.util.Arrays;
​
class Solution {
public String[] reorderLogFiles(String[] logs) {
Arrays.sort(logs, (a, b) -> {
int indexA = a.indexOf(" ") + 1;
int indexB = b.indexOf(" ") + 1;
boolean aIsLetter = Character.isLetter(a.charAt(indexA)); // check for letter
boolean bIsLetter = Character.isLetter(b.charAt(indexB)); // check for letter
​
if (aIsLetter && bIsLetter) {
// Compare the contents of the logs
int cmp = a.substring(indexA).compareTo(b.substring(indexB));
if (cmp != 0) {
return cmp;
}
// If contents are the same, compare identifiers
return a.substring(0, indexA).compareTo(b.substring(0, indexB));
} else if (aIsLetter && !bIsLetter) {
return -1; // Letter logs come before digit logs
} else if (!aIsLetter && bIsLetter) {
return 1; // Digit logs come after letter logs
} else {
return 0; // Maintain original order for digit logs
}
});
return logs;
}
}
​