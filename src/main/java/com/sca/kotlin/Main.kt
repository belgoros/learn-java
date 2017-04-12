package com.sca.kotlin


    fun main(args: Array<String>) {
        println("Printing an Option: " + checkOption(Option.DONE))
    }

    fun checkOption(option: Option): String {
        return option.toString()
    }
