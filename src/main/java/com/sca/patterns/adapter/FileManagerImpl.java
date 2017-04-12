package com.sca.patterns.adapter;

public class FileManagerImpl extends FileManagerUtil implements FileManager {

    @Override
    public String open(String s) {
        return new Boolean(openFile(s)).toString();
    }

    @Override
    public String close() {
        return new Boolean(closeFile()).toString();
    }

    @Override
    public String read(int pos, int amount, byte[] data) {
        return readFromFile(pos, amount);
    }

    @Override
    public String write(int pos, int amount, byte[] data) {
        boolean tmp = writeToFile(new String(data), pos, amount);
        return String.valueOf(tmp);
    }

}
