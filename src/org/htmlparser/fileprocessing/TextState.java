package org.htmlparser.fileprocessing;

import org.htmlparser.data.structure.Tree;

import java.io.IOException;

public class TextState implements State {

    private Tree tree;
    private HtmlReader htmlReader;
    private StringBuilder text;

    public TextState(HtmlReader htmlReader, Tree tree) {
        this.htmlReader = htmlReader;
        this.text = new StringBuilder();
        this.tree = tree;
    }

    public TextState(HtmlReader htmlReader, Tree tree, StringBuilder text) {
        this.htmlReader = htmlReader;
        this.text = text;
        this.tree = tree;
    }

    @Override
    public void process(char c) throws IOException {
        if (c == '<') {
            if (text.length() > 0)
                tree.addTextValue(text);
            char nextSymbol = (char) htmlReader.getFileReader().read();
            if (nextSymbol == '/') {
                htmlReader.setState(new ClosingTagState(htmlReader, tree));
            } else {
                htmlReader.setState(new OpeningTagState(htmlReader, nextSymbol, tree));
            }
        } else {
            if (c != '\n' && c != '\r')
                text.append(c);
        }
    }
}
