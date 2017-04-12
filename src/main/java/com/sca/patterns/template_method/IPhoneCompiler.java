package com.sca.patterns.template_method;

public class IPhoneCompiler extends CrossCompiler {

    @Override
    protected void collectSource() {
        // anything specific to this class

    }

    @Override
    protected void compileToTarget() {
        System.out.println("Hey, I'm compiling to OS X only");

    }

}
