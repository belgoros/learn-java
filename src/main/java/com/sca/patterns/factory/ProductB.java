package com.sca.patterns.factory;

public class ProductB extends Product {

    /*
     * (non-Javadoc)
     * 
     * @see patterns.factory.Product#writeName(java.lang.String)
     */
    @Override
    public void writeName(String name) {
        StringBuilder tempName = new StringBuilder().append(name);
        System.out.println("My reversed name is" + tempName.reverse());
    }

}
