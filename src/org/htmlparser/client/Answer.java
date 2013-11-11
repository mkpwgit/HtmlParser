package org.htmlparser.client;


public class Answer {

    private String tagsString;
    private String text;

    public Answer(String text) {
        tagsString = "";
        this.text = text;
    }

    public Answer(String tagsString, String text) {
        this.tagsString = tagsString;
        this.text = text;
    }

    public void print() {
        System.out.println(tagsString);
        System.out.println();
        System.out.println(text);
    }

}
