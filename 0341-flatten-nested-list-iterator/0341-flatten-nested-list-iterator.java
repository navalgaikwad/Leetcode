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
    List<NestedInteger> nestedList =  new ArrayList<>(); 
    int i=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }
    
    void dfs(List<NestedInteger> nestedList) {
        for(NestedInteger list: nestedList) {
            if(list.isInteger()) {
                result.add(list.getInteger());
            }else {
                dfs(list.getList());
            }
        }
    }
    
    @Override
    public Integer next() {
        return result.get(i++);
    }

    @Override
    public boolean hasNext() {
         return i<result.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */