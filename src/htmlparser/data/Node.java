package htmlparser.data;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private Node parent;
    private List<Node> children;
    private String name;

    public Node() {

    }

    public Node(Node parent, String name) {
        this.parent = parent;
        this.name = name;
        this.children = new ArrayList<Node>();
    }
}
