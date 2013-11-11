package org.htmlparser.client;

import org.htmlparser.common.Constants;
import org.htmlparser.data.structure.Tree;
import org.htmlparser.filereader.HtmlReader;

import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) {

        System.out.println("Терминал запущен.");
        System.out.print("Введите путь к файлу html: ");

        Scanner sc = new Scanner(System.in);
        String pathToFile = sc.next();

        HtmlReader htmlReader = new HtmlReader(pathToFile);
        htmlReader.read();

        CommandProcessing commandProcessing = new CommandProcessing(htmlReader.getTree());

        while (true) {
            System.out.print("Введите команду: ");
            String textCommand = sc.next();
            if (textCommand.equalsIgnoreCase(Constants.EXIT) || textCommand.equalsIgnoreCase(Constants.QUIT))
                break;
            Answer answer = commandProcessing.getTagValue(textCommand);
            answer.print();
            System.out.println(Tree.tags);
        }


    }
}
