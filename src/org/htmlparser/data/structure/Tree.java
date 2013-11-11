package org.htmlparser.data.structure;

import org.htmlparser.client.Answer;
import org.htmlparser.client.Command;
import org.htmlparser.common.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tree {

    private Node head;
    private Node currentNode;

    public static String tags;

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
        for (Node node : currentNode.getChildren()) {
            if (node.getName().equals(command.getName()) && currentNumber-- == 1) {
                currentNode = node;
                return true;
            }
        }
        return false;
    }

    public Answer getValueByTag(List<Command> commands) {
        updateTree();
        for (int i = 1; i < commands.size(); i++) {
            if (!findNode(commands.get(i))) {
                return new Answer(Constants.TAG_IS_NOT_FOUND);
            }
        }
        String result = getValue();
        if (result.isEmpty()) {
            String tagsString = getInnerTags(currentNode, "");
            return new Answer(tagsString, Constants.EMPTY_TAG_VALUE);
        } else {
            String tagsString = getInnerTags(currentNode, "");
            return new Answer(tagsString, result.substring(0, 60));
        }
    }

    public String getValue() {
        return new String(currentNode.getValue());
    }

    public void updateTree() {
        currentNode = head;
    }

    public String getInnerTags(Node node, String result) {
        for (Node child : node.getChildren()) {
            System.out.println(result);
            tags+=child.getName();
            getInnerTags(child, result);
        }
        return result;
    }
}
