package LeetCode341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation

// When submit, Let NestedIterator become public;
class NestedIterator implements Iterator<Integer> {
    List<Integer> data = new ArrayList<>();
    int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.dfs(nestedList);
        index = 0;
    }

    @Override
    public Integer next() {
        return data.get(index ++);
    }

    @Override
    public boolean hasNext() {
        return index < data.size();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger e : nestedList) {
            if (e.isInteger()) {
                data.add(e.getInteger());
            } else {
                dfs(e.getList());
            }
        }
    }
}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */