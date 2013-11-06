package org.htmlparser.client;

import org.htmlparser.data.structure.Tree;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessing {

    private final String EMPTY_TAG_VALUE = "Текстовое содержимое отсутствует";

    private Tree tree;

    public CommandProcessing(Tree tree) {
        this.tree = tree;
    }

    private ArrayList<Command> createCommands(String text) {
        ArrayList<Command> commands = new ArrayList<Command>();
        String[] textCommands = text.split("/");
        for (String textCommand : textCommands) {
            String[] textCommandParts = textCommand.split("\\[");
            String name = textCommandParts[0];
            Command command = null;
            if (textCommandParts.length == 2) {
                String number = textCommandParts[1].replace("]", "");
                command = new Command(name, number);
            } else {
                command = new Command(name);
            }

            commands.add(command);
        }
        return commands;
    }

    public String getTagValue(String text) {
        tree.updateTree();
        List<Command> commands = createCommands(text);
        String tagValue = EMPTY_TAG_VALUE;
        tagValue = tree.getValueByTag(commands);
       /* if (commands.get(0).getName().equals("html")) {
            for (int i = 1; i < commands.size(); i++) {
                tree.findNode(commands.get(i));
            }
            tagValue = tree.getValue();
        }*/
        return tagValue;
    }
}
