package com.sca.patterns.template_method;

public class AndroidCompiler extends CrossCompiler {

    @Override
    protected void collectSource() {
        // anything specific to this class

    }

    @Override
    protected void compileToTarget() {
        // android specific compilation
        System.out.println("Hey, I'm compiling to Android only");

    }

}
