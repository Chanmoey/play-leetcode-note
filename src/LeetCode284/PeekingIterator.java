package LeetCode284;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年04月25日
 */
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    List<Integer> list;
    int peekIdx;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        this.peekIdx = 0;
        this.iterator = list.iterator();
    }

    public Integer peek() {
        return this.list.get(peekIdx);
    }

    @Override
    public Integer next() {
        this.peekIdx++;
        return this.iterator.next();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
}
