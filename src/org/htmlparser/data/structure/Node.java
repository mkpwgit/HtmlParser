package org.htmlparser.data.structure;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private Node parent;
    private List<Node> children;
    private String name;
    private StringBuilder value;

    public Node() {

    }

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<Node>();
        this.value = new StringBuilder();
    }

    public void addValue(StringBuilder value) {
        this.value.append(value);
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
