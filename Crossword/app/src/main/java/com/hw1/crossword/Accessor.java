package com.totsp.crossword;

import java.text.SimpleDateFormat;
import java.util.Comparator;


public interface Accessor extends Comparator<com.totsp.crossword.FileHandle> {
    Accessor DATE_ASC = new Accessor() {
            @SuppressWarnings("SimpleDateFormat")
            public String getLabel(com.totsp.crossword.FileHandle o) {
                SimpleDateFormat df = new SimpleDateFormat("EEEEEEEEE MMM dd, yyyy");

                return df.format(o.getDate());
            }

            public int compare(com.totsp.crossword.FileHandle object1, com.totsp.crossword.FileHandle object2) {
                return object1.getDate()
                              .compareTo(object2.getDate());
            }
        };

    Accessor DATE_DESC = new Accessor() {
            @SuppressWarnings("SimpleDateFormat")
            public String getLabel(com.totsp.crossword.FileHandle o) {
                SimpleDateFormat df = new SimpleDateFormat("EEEEEEEEE MMM dd, yyyy");

                return df.format(o.getDate());
            }

            public int compare(com.totsp.crossword.FileHandle object1, com.totsp.crossword.FileHandle object2) {
                return object2.getDate()
                              .compareTo(object1.getDate());
            }
        };

    Accessor SOURCE = new Accessor() {
            public String getLabel(com.totsp.crossword.FileHandle o) {
                return o.getSource();
            }

            public int compare(com.totsp.crossword.FileHandle object1, com.totsp.crossword.FileHandle object2) {
                return object1.getSource()
                              .compareTo(object2.getSource());
            }
        };

    String getLabel(com.totsp.crossword.FileHandle o);
}
