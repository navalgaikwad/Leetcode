/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> result = new ArrayList<>();
    int index =0;
    public NestedIterator(List<NestedInteger> nestedList) {
       helper(nestedList);
    }
    void helper(List<NestedInteger> nestedList) {
         for(NestedInteger nI:nestedList) {
            if(nI.isInteger()) {
                result.add(nI.getInteger());
            }else {
                helper(nI.getList());
            }
        }
    }
    @Override
    public Integer next() {
        if(hasNext()) return result.get(index++);
        return 0;
    }

    @Override
    public boolean hasNext() {
        return index < result.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */