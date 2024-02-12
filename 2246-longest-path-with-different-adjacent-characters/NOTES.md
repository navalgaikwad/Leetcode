// if the longest length we got from our child is greater than our max length
// the child's max length becomes the so far discovered max length
// and the previous max length becomes the second max
if (maxLenFromChild > maxLen) {
secondMaxLen = maxLen;
maxLen = maxLenFromChild;
}
// else if the length obtained from child is smaller than max length
// but greater than second max length, we update second max length
else if (maxLenFromChild > secondMaxLen) {
secondMaxLen = maxLenFromChild;
}
}
​
// as previously discussed, two longest lengths under a node will combine along with the node itself
// to form a subtree like path (a subtree with two branches/paths)
// so maxLen + secondMaxLen + 1 (the current node itself)
longestPath = Math.max(longestPath, maxLen + secondMaxLen + 1);     // we update the so far discovered longest path length
// we return the max length of path + 1 (the current node itself) for utilisation upon backtracking
// this max length is length of the path we are in right now
return maxLen + 1;
}
}
​
// TC: O(e + v), SC: O(e + v)