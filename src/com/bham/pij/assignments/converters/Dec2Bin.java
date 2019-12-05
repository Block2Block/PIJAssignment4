package com.bham.pij.assignments.converters;

public class Dec2Bin implements IConverter{
    @Override
    public String convert(String s) {
        return convert(s, 8);
    }

    public String convert(String s, int bits) {
        int dec;
        try {
             dec = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException();
        }

        int max = (int) Math.pow(2, bits);
        if (dec >= max*2||dec < 0) {
            return null;
        }
        StringBuilder binary = new StringBuilder();
        for (int i2 = max / 2;binary.length() < bits;i2 = i2 / 2) {
            if (i2 > dec) {
                binary.append("0");
            } else {
                binary.append("1");
                dec -= i2;
            }
        }
        return binary.toString();
    }

    @Override
    public boolean isValid(String s) {
        if (!s.matches("[0-9]{1,3}")) {
            return false;
        }

        int number;
        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return number >= 0 && number <= 255;
    }
}
