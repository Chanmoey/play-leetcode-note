package polytreenode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2021年12月16日 9:05
 * @description
 */
public class PolyTreeNode {

    Integer value;
    List<PolyTreeNode> next;

    public PolyTreeNode(Integer value) {
        this.value = value;
        this.next = new ArrayList<>();
    }

    public void setChild(Integer child) {
        this.next.add(new PolyTreeNode(child));
    }
}
