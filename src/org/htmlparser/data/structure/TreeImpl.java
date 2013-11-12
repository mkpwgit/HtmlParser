package org.htmlparser.data.structure;

import org.htmlparser.client.Answer;
import org.htmlparser.client.Command;
import org.htmlparser.common.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeImpl implements Tree{

    private Node head;
    private Node currentNode;

    public TreeImpl(Node head) {
        head.setParent(null);
        this.head = head;
        this.currentNode = head;
    }

    public TreeImpl() {

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

    public void addTextValue(StringBuilder value) {
        currentNode.addValue(value);
    }

    private boolean findNode(Command command) {
        int currentNumber = command.getNumber();
        for (Node node : currentNode.getChildren()) {
            if (node.getName().equals(command.getName()) && currentNumber-- == 1) {
                currentNode = node;
                return true;
            }
        }
        return false;
    }

    public Answer getAnswerOnCommands(List<Command> commands) {
        updateTree();
        for (int i = 1; i < commands.size(); i++) {
            if (!findNode(commands.get(i))) {
                return new Answer(Constants.TAG_IS_NOT_FOUND);
            }
        }
        String resultText = getTextValue();
        StringBuilder tagsString = new StringBuilder();
        getInnerTags(currentNode, tagsString);
        if (resultText.isEmpty()) {
            return new Answer(tagsString.toString(), Constants.EMPTY_TAG_VALUE);
        } else {
            if (resultText.length() > 60)
                resultText = resultText.substring(0, 60);
            return new Answer(tagsString.toString(), resultText);
        }
    }

    private String getTextValue() {
        return new String(currentNode.getValue());
    }

    private void updateTree() {
        currentNode = head;
    }

    private void getInnerTags(Node node, StringBuilder innerTagsString) {
        for (Node child : node.getChildren()) {
            innerTagsString.append("<"+child.getName());
            getInnerTags(child, innerTagsString);
        }
    }
}
