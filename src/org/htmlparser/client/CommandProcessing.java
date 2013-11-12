package org.htmlparser.client;

import org.htmlparser.data.structure.Tree;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessing {

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

    public Answer getAnswerOnCommands(String text) {
        //remove first slash
        text = text.substring(1, text.length());
        List<Command> commands = createCommands(text);
        return tree.getAnswerOnCommands(commands);
    }
}
