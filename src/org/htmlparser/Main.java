package org.htmlparser;

import org.htmlparser.data.structure.Node;
import org.htmlparser.data.structure.Tree;
import org.htmlparser.filereader.HtmlReader;
import org.htmlparser.tag.Tags;

public class Main {

    public static void main(String[] args) {
        Node node = new Node("html");
        Node node2 = new Node("body");
        Node node3 = new Node("head");

       /* Tree tree = new Tree(node);

        tree.addChild(node2);
        tree.addValue(new StringBuilder("new body"));

        tree.changeCurrentNode();

        tree.addChild(node3);
        tree.addValue(new StringBuilder("new head"));*/

//        System.out.println();

        System.out.println(Tags.isElement("html"));
        HtmlReader htmlReader = new HtmlReader("test.html");

        htmlReader.read();
        System.out.println("hello");


    }
}
