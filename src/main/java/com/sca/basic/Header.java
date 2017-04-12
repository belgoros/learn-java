package com.sca.basic;

/**
 * Created by ZFTC0418 on 27/03/2015.
 */
public enum Header {
    TEST1, TEST2, TEST_DUMMY;

    private final String title;

    private Header() {
        this.title = name().toLowerCase();
    }

    public String getTitle() {
        return title;
    }
}
