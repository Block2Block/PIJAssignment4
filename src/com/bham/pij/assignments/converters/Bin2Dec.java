package com.bham.pij.assignments.converters;

public class Bin2Dec implements IConverter {
    @Override
    public String convert(String s) {
        if (!s.matches("[0,1]+")) {
            throw new InvalidFormatException();
        }
        int dec = 0;
        int add = (int) Math.pow(2, s.length() - 1);
        for (char c : s.toCharArray()) {
            if (c == '1') {
                dec += add;
            }
            add = add / 2;
        }
        return dec + "";
    }

    @Override
    public boolean isValid(String s) {
        return s.matches("[0,1]{8}");
    }
}
