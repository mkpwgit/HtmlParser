package org.htmlparser.client;


import org.htmlparser.common.Constants;

public class Answer {

    private String innerTagsString;
    private String text;

    public Answer(String text) {
        this.text = text;
    }

    public Answer(String tagsString, String text) {
        this.innerTagsString = tagsString;
        this.text = text;
    }

    public void print() {
        if (innerTagsString != null)
            if (innerTagsString.isEmpty()) {
                System.out.println(Constants.INNER_TAGS_ARE_NOT_FOUND);
            } else
                System.out.println("Вложенные теги: " + innerTagsString);
        System.out.println(text);
    }

}
