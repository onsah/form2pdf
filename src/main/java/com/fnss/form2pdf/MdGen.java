package com.fnss.form2pdf;

public class MdGen {
    private static final char HEADER    = '#';
    private static final char SPACE     = ' ';
    private static final char NEWLINE   = '\n';

    private final StringBuilder sb = new StringBuilder();

    private String cache = null;

    public MdGen() {

    }

    public void addHeader(int level, String text) {
        cache = null;
        if (level <= 0) {
            throw new IllegalArgumentException("level can not be zero or less");
        }
        for (int i = 0; i < level; ++i)
            appendHeader();
        appendSpace();
        appendText(text);
        appendLine();
    }

    private void appendHeader() {
        sb.append(HEADER);
    }

    private void appendSpace() {
        sb.append(SPACE);
    }

    private void appendText(String text) {
        sb.append(text);
    }
    
    private void appendLine() {
        sb.append(NEWLINE);
    }

    @Override
    public String toString() {
        if (cache == null) {
            cache = sb.toString();
        }
        return cache;
    }
}