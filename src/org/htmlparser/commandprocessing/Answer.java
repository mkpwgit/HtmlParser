package org.htmlparser.commandprocessing;


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
        //print information about tags
        if (innerTagsString != null)
            if (innerTagsString.isEmpty()) {
                System.out.println(Constants.INNER_TAGS_ARE_NOT_FOUND);
            } else
                System.out.println(Constants.INNER_TAGS + innerTagsString);

        //print tag's value
        if (text.isEmpty())
            text=Constants.EMPTY_TAG_VALUE;
        System.out.println(text);
    }

}
