package org.htmlparser.data.structure;

import org.htmlparser.client.Command;

import java.util.List;

public class Tree {

    private final String TAG_IS_NOT_FOUND = "Тег не был найден";

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

    public boolean findNode(Command command) {
        int currentNumber = command.getNumber();
        for (Node node: currentNode.getChildren()) {
            if (node.getName().equals(command.getName()) && currentNumber--==1) {
                currentNode = node;
                return true;
            }
        }
        return false;
    }

    public String getValueByTag(List<Command> commands) {
        updateTree();
        for (int i=1; i<commands.size(); i++) {
            if (!findNode(commands.get(i)))
                return TAG_IS_NOT_FOUND;
        }
        return getValue();

    }

    public String getValue() {
        return new String(currentNode.getValue());
    }

    public void updateTree() {
        currentNode = head;
    }
}
