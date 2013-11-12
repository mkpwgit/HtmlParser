package org.htmlparser.process;

import org.htmlparser.data.structure.Tree;
import org.htmlparser.filereader.HtmlReader;

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
    public void process(char c) {
        if (c == '<') {
            System.out.println(text + " text "+text.length());
            if (text.length()>0)
                tree.addTextValue(text);
            try {
                char nextSymbol = (char) htmlReader.getFileReader().read();
                if (nextSymbol == '/') {
                    htmlReader.setState(new ClosingTagState(htmlReader, tree));
                } else {
                    htmlReader.setState(new OpeningTagState(htmlReader, nextSymbol, tree));
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } else {
            if (c != '\n' && c!= '\r')
                text.append(c);
        }
    }
}
