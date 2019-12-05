package com.bham.pij.assignments.converters;

public class Hex2Bin implements IConverter {

    @Override
    public String convert(String s) {
        Dec2Bin decToBin = new Dec2Bin();

        StringBuilder bin = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            int index = hexValues.indexOf(c);
            bin.append(decToBin.convert(index + "", 4));
            i++;
        }

        return bin.toString();
    }

    @Override
    public boolean isValid(String s) {
        return s.matches("[0-9A-F]{2}");
    }
}
