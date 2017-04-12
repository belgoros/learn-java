package com.sca.patterns.iterator;

/**
 * Created by ZFTC0418 on 02/02/2015.
 */
public interface DvdListIterator {
    public void first();

    public void next();

    public boolean isDone();

    public String currentItem();
}
