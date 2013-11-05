package org.htmlparser.tag;

public enum Tags {
    html, head, title, meta, body, div, script, ul, li, table, tbody, tr, td, h1;

    public static boolean isElement(String name) {
        for (Tags tag: Tags.values()) {
            if (name.equals(tag.toString()))
                return true;
        }
        return false;
    }

}
