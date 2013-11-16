package org.htmlparser.fileprocessing;

import org.htmlparser.data.structure.Tree;
import org.htmlparser.data.structure.TreeImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HtmlReader {

    private FileReader fileReader;
    private State currentState;
    private Tree tree;

    public HtmlReader(String fileName) throws FileNotFoundException {
        fileReader = new FileReader(fileName);
        tree = new TreeImpl();
        currentState = new TextState(this, tree);
    }

    public void read() throws IOException {
        int c;
        while ((c = fileReader.read()) != -1) {
            currentState.process((char) c);
        }
    }

    public State getState() {
        return currentState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public Tree getTree() {
        return tree;
    }
}
