package org.htmlparser.process;

import org.htmlparser.data.structure.Tree;
import org.htmlparser.filereader.HtmlReader;
import org.htmlparser.tag.Tags;

public class ClosingTagState implements State {

    private Tree tree;
    private HtmlReader htmlReader;
    private StringBuilder tag;

    public ClosingTagState(HtmlReader htmlReader, Tree tree) {
        this.htmlReader = htmlReader;
        this.tag = new StringBuilder();
        this.tree = tree;
    }

    @Override
    public void process(char c) {
        if (c == '>') {
            if (Tags.isElement(new String(tag))) {
                tree.changeCurrentNode();
                htmlReader.setState(new TextState(htmlReader, tree));
            } else {
                htmlReader.setState(new TextState(htmlReader, tree, tag));
            }
        } else {
            tag.append(c);
        }
    }
}
