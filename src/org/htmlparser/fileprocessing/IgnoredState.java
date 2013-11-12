package org.htmlparser.fileprocessing;


import org.htmlparser.data.structure.Tree;

import java.io.IOException;

public class IgnoredState implements State {

    private Tree tree;
    private HtmlReader htmlReader;

    public IgnoredState(HtmlReader htmlReader, Tree tree) {
        this.htmlReader = htmlReader;
        this.tree = tree;
    }

    @Override
    public void process(char c) throws IOException {
        if (c == '>') {
            htmlReader.setState(new TextState(htmlReader, tree));
        }
    }
}
