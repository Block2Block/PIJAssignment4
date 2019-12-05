package com.bham.pij.assignments.converters;

public class Bin2Hex implements IConverter {
    @Override
    public String convert(String s) {
        try {
            Bin2Dec binToDec = new Bin2Dec();
            int firstNibble = Integer.parseInt(binToDec.convert(s.substring(0, 4)));
            int secondNibble = Integer.parseInt(binToDec.convert(s.substring(4, 8)));
            return hexValues.get(firstNibble).toString() + hexValues.get(secondNibble).toString();
        } catch (NumberFormatException e) {
            throw new InvalidFormatException();
        }
    }

    @Override
    public boolean isValid(String s) {
        return s.matches("[0,1]{8}");
    }
}
