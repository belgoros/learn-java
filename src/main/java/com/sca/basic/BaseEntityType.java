package com.sca.basic;

public final class BaseEntityType<T> {

    private Class<T> typeArgumentClass;

    public BaseEntityType(Class<T> typeArgumentClass) {
        this.typeArgumentClass = typeArgumentClass;
    }

    public void doSomethingThatRequiresNewT() throws Exception {
        T myNewT = typeArgumentClass.newInstance();
    }
}
