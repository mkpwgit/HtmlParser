package org.htmlparser.fileprocessing;


import java.io.IOException;

public interface State {

    void process(char c) throws IOException;
}
