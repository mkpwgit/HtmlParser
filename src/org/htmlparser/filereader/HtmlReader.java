package org.htmlparser.filereader;

import org.htmlparser.data.structure.Tree;
import org.htmlparser.data.structure.TreeImpl;
import org.htmlparser.process.State;
import org.htmlparser.process.TextState;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HtmlReader {

    private FileReader fileReader;
    private State currentState;
    private Tree tree;

    public HtmlReader(String fileName) {
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            new IllegalArgumentException("File not found exception. Parameter fileName is not correct");
        }
        tree = new TreeImpl();
        currentState = new TextState(this, tree);
    }

    public void read() {
        try {
            int c;
            while ((c = fileReader.read()) != -1) {
                currentState.process((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
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
