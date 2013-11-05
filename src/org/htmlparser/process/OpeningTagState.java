package org.htmlparser.process;


import org.htmlparser.filereader.HtmlReader;
import org.htmlparser.tag.Tags;

public class OpeningTagState implements State{

    private HtmlReader htmlReader;
    private StringBuilder tag;

    public OpeningTagState(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
        this.tag = new StringBuilder();
    }

    public OpeningTagState(HtmlReader htmlReader, char c) {
        this.htmlReader = htmlReader;
        this.tag = new StringBuilder().append(c);
    }

    @Override
    public void process(char c) {
        if (c == '>') {
            System.out.println(tag + " opening tag");

            htmlReader.setState(new TextState(htmlReader));
        } else {
            tag.append(c);
        }
    }
}
