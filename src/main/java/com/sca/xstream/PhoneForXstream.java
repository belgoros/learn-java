package com.sca.xstream;

public class PhoneForXstream {
    private int code;
    private String number;

    public PhoneForXstream(int code, String number) {
        this.code = code;
        this.number = number;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
