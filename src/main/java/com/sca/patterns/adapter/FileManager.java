package com.sca.patterns.adapter;

public interface FileManager {
    String open(String s);

    String close();

    String read(int pos, int amount, byte[] data);

    String write(int pos, int amount, byte[] data);
}
