package org.htmlparser.client;

import org.htmlparser.filereader.HtmlReader;

import java.util.Scanner;

public class Terminal {

    public static void main(String [] args) {

        System.out.println("Терминал запущен.");
        System.out.print("Введите путь к файлу html: ");

        Scanner sc = new Scanner(System.in);
        String pathToFile = sc.next();

        HtmlReader htmlReader = new HtmlReader(pathToFile);
        htmlReader.read();

        CommandProcessing commandProcessing = new CommandProcessing(htmlReader.getTree());

        System.out.print("Введите команду: ");
        String textCommand = sc.next();

        System.out.println(commandProcessing.getTagValue(textCommand));
    }
}
