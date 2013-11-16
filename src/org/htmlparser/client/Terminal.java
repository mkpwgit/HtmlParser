package org.htmlparser.client;

import org.htmlparser.commandprocessing.Answer;
import org.htmlparser.commandprocessing.CommandProcessing;
import org.htmlparser.common.Constants;
import org.htmlparser.fileprocessing.HtmlReader;

import java.io.IOException;
import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) throws IOException {

        boolean isFileOpen = true;
        Scanner sc = null;
        HtmlReader htmlReader = null;

        System.out.println(Constants.TERMINAL_RUN);
        System.out.println(Constants.HELP);

        //process file
        do {
            System.out.print(Constants.ENTER_FILE_PATH);

            try {
                sc = new Scanner(System.in);
                String pathToFile = sc.next();

                htmlReader = new HtmlReader(pathToFile);
                htmlReader.read();
                isFileOpen = true;
            } catch (Exception e) {
                System.out.println(Constants.ERROR_FILE_READING);
                isFileOpen = false;
            }

        } while (!isFileOpen);

        System.out.println(Constants.FILE_PROCESSING_FINISH);

        //process commands
        CommandProcessing commandProcessing = new CommandProcessing(htmlReader.getTree());

        while (true) {
            System.out.print(Constants.ENTER_COMMAND);
            try {
                String textCommand = sc.next();
                if (textCommand.equalsIgnoreCase(Constants.EXIT) || textCommand.equalsIgnoreCase(Constants.QUIT))
                    break;
                Answer answer = null;

                answer = commandProcessing.getAnswerOnCommands(textCommand);
                answer.print();
            } catch (Exception e) {
                System.out.println(Constants.WRONG_COMMAND);
            }
        }

    }
}
