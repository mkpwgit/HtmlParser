package org.htmlparser.process;

import org.htmlparser.filereader.HtmlReader;

public class ClosingTagState implements State {

    private HtmlReader htmlReader;
    private StringBuilder tag;

    public ClosingTagState(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
        this.tag = new StringBuilder();
    }

    @Override
    public void process(char c) {
        if (c == '>') {
            System.out.println(tag + " close tag");
            htmlReader.setState(new TextState(htmlReader));
        } else {
            tag.append(c);
        }
    }
}
