public class Solution {
public boolean isRobotBounded(String instructions) {
int x = 0, y = 0; // Robot's starting position
int dir = 0; // 0 = North, 1 = East, 2 = South, 3 = West
​
for (char c : instructions.toCharArray()) {
if (c == 'G') {
if (dir == 0) y++;       // Facing North
else if (dir == 1) x++;  // Facing East
else if (dir == 2) y--;  // Facing South
else if (dir == 3) x--;  // Facing West
} else if (c == 'L') {
dir = (dir == 0) ? 3 : dir - 1; // Turn left
} else if (c == 'R') {
dir = (dir == 3) ? 0 : dir + 1; // Turn right
}
}
​
// Robot is in a loop if it returns to the origin or is not facing North
return (x == 0 && y == 0) || dir != 0;
}
​
public static void main(String[] args) {
Solution solution = new Solution();
String instructions = "GGLLGG";
System.out.println("Is Robot Bounded? " + solution.isRobotBounded(instructions));
}
}
​