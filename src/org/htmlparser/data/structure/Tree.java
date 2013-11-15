package org.htmlparser.data.structure;

import org.htmlparser.commandprocessing.Answer;
import org.htmlparser.commandprocessing.Command;

import java.util.List;

/**
 * Interface for work with tree that keep {@link Node}.
 *
 */
public interface Tree {

    /**
     * Add child for the current node.
     *
     * @param node Tree node
     */
    public void addChild(Node node);

    /**
     * Change current node. After that current node is the parent of the previous current node.
     *
     */
    public void changeCurrentNode();

    /**
     * Add text value to current node.
     * Text value is concatenated with current text value of the node.
     *
     * @param value
     */
    public void addTextValue(StringBuilder value);

    /**
     * Find text value of requested tag and all inner tags.
     *
     * @param commands list of {@link Command} objects
     * @return Answer object
     */
    public Answer getAnswerOnCommands(List<Command> commands);

}
