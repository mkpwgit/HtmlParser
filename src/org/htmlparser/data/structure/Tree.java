package org.htmlparser.data.structure;

public class Tree {

    private Node head;
    private Node currentNode;

    public Tree(Node head) {
        head.setParent(null);
        this.head = head;
        this.currentNode = head;
    }

    public Tree() {

    }

    public void addChild(Node node) {
        if (head == null) {
            node.setParent(null);
            head = node;
            currentNode = head;
        } else {
            node.setParent(currentNode);
            currentNode.getChildren().add(node);
            currentNode = node;
        }
    }

    public void changeCurrentNode() {
        currentNode = currentNode.getParent();
    }

    public void addValue(StringBuilder value) {
        currentNode.addValue(value);
    }
}
