package org.htmlparser.client;


import org.htmlparser.common.Constants;

public class Answer {

    private String innerTagsString;
    private String text;

    public Answer(String text) {
        this.text = text.trim();
    }

    public Answer(String tagsString, String text) {
        this.innerTagsString = tagsString;
        this.text = text.trim();
    }

    public void print() {
        if (innerTagsString != null)
            if (innerTagsString.isEmpty()) {
                System.out.println(Constants.INNER_TAGS_ARE_NOT_FOUND);
            } else
                System.out.println("Вложенные теги: " + innerTagsString);
        if (text.length()==0)
            text=Constants.EMPTY_TAG_VALUE;
        System.out.println(text);
    }

}
