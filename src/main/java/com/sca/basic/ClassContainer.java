package com.sca.basic;

public class ClassContainer<E> {

    E createContents(Class<E> clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}
