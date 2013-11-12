package org.htmlparser.client;

public class Command {

    private String name;
    private int number;

    public Command(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Command(String name, String number) {
        this.name = name;
        if (!number.isEmpty()) {
            this.number = Integer.valueOf(number);
        } else {
            this.number = 1;
        }
    }

    public Command(String name) {
        this.name = name;
        this.number=1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
