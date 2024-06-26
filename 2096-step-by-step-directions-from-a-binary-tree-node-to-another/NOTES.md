root = findAncestor(root, startValue, destValue);
helperParent(root, startValue);
helperDestValue(root, destValue);
leftSide.append(rightSide.reverse());
return leftSide.toString();