import htmlparser.data.Node;
import htmlparser.data.Tree;

public class Main {

    public static void main(String[] args) {
        Node node = new Node("html");
        Node node2 = new Node("body");
        Node node3 = new Node("head");

        Tree tree = new Tree(node);

        tree.addChild(node2);
        tree.addValue("new body");

        tree.changeCurrentNode();

        tree.addChild(node3);
        tree.addValue("new head");

        System.out.println();




    }
}
