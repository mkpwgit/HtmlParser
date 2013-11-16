package org.htmlparser.common;

public class Constants {

    //messages
    public static final String TAG_IS_NOT_FOUND = "Запрашиваемый элемент не существует";
    public static final String EMPTY_TAG_VALUE = "Текстовое содержимое отсутствует";
    public static final String INNER_TAGS_ARE_NOT_FOUND = "Вложенные теги отсутствуют";
    public static final String INNER_TAGS = "Вложенные тэги: ";

    //commands
    public static final String QUIT = "quit";
    public static final String EXIT = "exit";

    //terminal
    public static final String HELP = "HELP: HTML файл должен начинаться тегом <html> " +
            "и заканчиваться тегом </html>. \n" +
            "Форматы команды: /html[1]/head/meta[2] \n" +
            "Команды для выхода: quit, exit";
    public static final String TERMINAL_RUN = "Терминал запущен.";
    public static final String ENTER_FILE_PATH = "Введите путь к файлу html: ";
    public static final String ERROR_FILE_READING = "Проблема с чтением файла. Попробуйте повторить ввод пути к файлу.";
    public static final String FILE_PROCESSING_FINISH = "Файл обработан.";
    public static final String ENTER_COMMAND = "Введите команду: ";
    public static final String WRONG_COMMAND = "Неправильная команда!";
}
