package com.example.tipcalculator;

class MyString {
    private final char[] value;

    public MyString(char[] value) {
        this.value = value;
    }

    public int length() {
        return value.length;
    }

    public char charAt(int index) {
        if (index < 0 || index >= value.length) {
            throw new IndexOutOfBoundsException();
        }
        return value[index];
    }

    // Add other methods as needed
}