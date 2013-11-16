package org.htmlparser.commandprocessing;

import org.htmlparser.data.structure.Tree;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessing {

    private Tree tree;

    public CommandProcessing(Tree tree) {
        this.tree = tree;
    }

    private ArrayList<Command> createCommands(String text) throws Exception {
        ArrayList<Command> commands = new ArrayList<Command>();
        String[] textCommands = text.split("/");
        for (String textCommand : textCommands) {
            String[] textCommandParts = textCommand.split("\\[");
            String name = textCommandParts[0];
            Command command = null;
            if (textCommandParts.length > 2) {
                throw new Exception("Неправильная команда!");
            } else if (textCommandParts.length == 2) {
                String number = textCommandParts[1].replace("]", "");
                command = new Command(name, number);
            } else {
                command = new Command(name);
            }
            commands.add(command);
        }
        return commands;
    }

    public Answer getAnswerOnCommands(String text) throws Exception {
        //remove first slash
        text = text.substring(1, text.length());

        List<Command> commands = createCommands(text);
        checkCommands(commands);

        return tree.getAnswerOnCommands(commands);
    }

    public void checkCommands(List<Command> commands) throws Exception {
        Command firstCommand = commands.get(0);
        if (!firstCommand.getName().equals("html")) {
            throw new Exception("Неправильная первая команда");
        } else if (firstCommand.getNumber() != 1) {
            throw new Exception("Неправильная первая команда");
        }

    }
}
