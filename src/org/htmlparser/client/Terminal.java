package org.htmlparser.client;

import org.htmlparser.common.Constants;
import org.htmlparser.data.structure.Tree;
import org.htmlparser.filereader.HtmlReader;

import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) {

        boolean isFileOpen = true;
        Scanner sc = null;
        HtmlReader htmlReader = null;

        System.out.println("Терминал запущен.");

        //process file
        do {
            System.out.print("Введите путь к файлу html: ");

            try {
                sc = new Scanner(System.in);
                String pathToFile = sc.next();

                htmlReader = new HtmlReader(pathToFile);
                htmlReader.read();
                isFileOpen = true;
            } catch (Exception e) {
                System.out.println("Проблема с чтением файла. Попробуйте повторить ввод пути к файлу.");
                isFileOpen = false;
            }

        } while (!isFileOpen);


        //process commands
        CommandProcessing commandProcessing = new CommandProcessing(htmlReader.getTree());

        while (true) {
            System.out.print("Введите команду: ");
            try {
                String textCommand = sc.next();
                if (textCommand.equalsIgnoreCase(Constants.EXIT) || textCommand.equalsIgnoreCase(Constants.QUIT))
                    break;
                Answer answer = null;

                answer = commandProcessing.getAnswerOnCommands(textCommand);
                answer.print();
            } catch (Exception e) {
                System.out.println("Неправильная команда!");
            }
        }

    }

}
