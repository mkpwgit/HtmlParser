package org.htmlparser.process;

import org.htmlparser.filereader.HtmlReader;

import java.io.IOException;

public class TextState implements State {

    private HtmlReader htmlReader;
    private StringBuilder text;

    public TextState(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
        this.text = new StringBuilder();
    }

    @Override
    public void process(char c) {
        if (c == '<') {
            System.out.println(text + " text");
            try {
                char nextSymbol = (char) htmlReader.getFileReader().read();
                if (nextSymbol == '/') {
                    htmlReader.setState(new ClosingTagState(htmlReader));
                } else {
                    htmlReader.setState(new OpeningTagState(htmlReader, nextSymbol));
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } else {
            if (c != '\n')
                text.append(c);
        }
    }
}
