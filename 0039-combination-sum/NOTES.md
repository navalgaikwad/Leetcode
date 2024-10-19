combination.add(num);
combinations.add(combination);
}
}
}
memo.put(target, combinations);
return combinations;
}
}
​
class Solution {
​
​
List<List<Integer>> result = new ArrayList<>();
public List<List<Integer>> combinationSum(int[] candidates, int target) {
dfsSum(candidates, target, 0, new ArrayList<>(), 0);
return result;
}
void dfsSum(int[] candidates, int target, int sum, ArrayList<Integer> runningList, int index) {
if(sum == target) {
result.add(new ArrayList<>(runningList));
return;
}
for(int i=index; i<candidates.length; i++) {
if(sum <= target) {
runningList.add(candidates[i]);
dfsSum(candidates, target, candidates[i] + sum, runningList, i); //duplicate hava asel tar i or nasel tar i + 1
runningList.remove(runningList.size() - 1);
}
}
}
}
​
​