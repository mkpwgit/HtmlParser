package org.htmlparser.fileprocessing;

import org.htmlparser.data.structure.Tree;
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
            //</tag  > - for this situation
            String resTag = new String(tag).trim();

            if (Tags.isElement(resTag)) {
                tree.changeCurrentNode();
                htmlReader.setState(new TextState(htmlReader, tree));
            } else {
                tag.insert(0, "</");
                tag.append('>');
                htmlReader.setState(new TextState(htmlReader, tree, tag));
            }
        } else {
            tag.append(c);
        }
    }
}
